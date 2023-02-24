package xyz.zapgrupos.services;


import xyz.zapgrupos.model.Grupo;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class GruposDAO implements ServiceDAO<Grupo, String>{

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    public GruposDAO(){
        if(this.verifyEntityManager()){
            this.createEntityManager();
        }
    }

    private boolean verifyEntityManager(){
        return !(entityManager == null || !entityManager.isOpen());
    }
    private void createEntityManager(){
        try {
            factory = Persistence.createEntityManagerFactory("default");
            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private EntityManager getEntityManager(){

        if(this.verifyEntityManager()){
            return entityManager;
        }

        this.createEntityManager();
        return entityManager;
    }

    public Grupo insert(Grupo grupo){
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(grupo);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        } finally {
            getEntityManager().close();
        }
        return grupo;
    }
    public Grupo update(Grupo grupo){
        Grupo ng = this.getById(grupo.getId());
        getEntityManager().getTransaction().begin();

        Field[] fields = Arrays.stream(grupo.getClass().getFields()).filter(
                e -> (e.getModifiers() == Modifier.PUBLIC)
        ).toArray(Field[]::new);

        for (Field prop: fields) {
            String field = prop.getName();
            new Log("--------------------------------------------------------------------------------------------------------------------------------");
            try{
                var oldValue = ng.getClass().getField(field).get(ng);
                var newValue = grupo.getClass().getField(field).get(grupo);
                if((oldValue == newValue) | newValue == null) {
                    new Log("O valor do '%s' são iguais em ng:%s e grupo: %s", field, oldValue,  newValue);
                } else {
                    new Log("O valor do '%s' são diferentes em ng:%s e grupo: %s", field,  oldValue,  newValue);
                    ng.getClass().getField(prop.getName()).set(ng,newValue);
                    new Log("[MODIFICADO] O valor do %s são diferentes em grupo:%s e ng: %s", field,  newValue,  oldValue);
                }
            }catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e){
                e.printStackTrace();
            }
        }
        getEntityManager().merge(ng);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
        return ng;
    }



    public List<Grupo> getAll() {
        List<Grupo> list = null;
        try {
            getEntityManager().getTransaction().begin();
            list =  getEntityManager().createNamedQuery("GruposQuery").getResultList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getEntityManager().close();
        }
        return list;
    }

    /**
     * Consulta o pessoa pelo ID.
     * @param id
     * @return o objeto Pessoa.
     */
    public Grupo getById(String id) {
        Grupo grupo = getEntityManager().find(Grupo.class, id);
        System.out.println("rumrmu: " + grupo.getId());
        try {
            if (grupo == null) {
                System.out.println("NÃO ENCONTRADO");
                return grupo;
            }
        } finally {
            getEntityManager().close();
        }
        return grupo;
    }
}