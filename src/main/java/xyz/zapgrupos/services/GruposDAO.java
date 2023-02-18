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

    private static GruposDAO instance = null;

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
            System.out.println("-------------------------------------[ERRO]--------------------------------------------");
            e.printStackTrace();
        }
    }

    private EntityManager getEntityManager(){
        System.out.println("[TESTE]"+this.verifyEntityManager());
        if(this.verifyEntityManager()){
            return entityManager;
        }

        this.createEntityManager();
        System.out.println("[TESTE]"+this.verifyEntityManager());
        return entityManager;
    }

    private void beging(){
        if(!getEntityManager().getTransaction().isActive()){
            getEntityManager().getTransaction().begin();
        }
    }

    public Grupo insert(Grupo grupo){
        try {
            this.beging();
            getEntityManager().persist(grupo);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        return grupo;
    }
    public Grupo update(Grupo grupo){
        Grupo ng = this.getById(grupo.getId());
        this.beging();
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
            this.beging();
            System.out.println(getEntityManager());
            list =  getEntityManager().createNamedQuery("GruposQuery").setMaxResults(10000).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Consulta o pessoa pelo ID.
     * @param id
     * @return o objeto Pessoa.
     */
    public Grupo getById(String id) {
        this.beging();
        Grupo grupo = getEntityManager().find(Grupo.class, id);
        System.out.println("rumrmu: " + grupo.getId());
        try {
            if (grupo == null) {
                System.out.println("NÃO ENCONTRADO");
                return grupo;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return grupo;
    }

}