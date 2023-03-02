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

    public static int i = 0;
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
        this.beging();
        getEntityManager().merge(grupo);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
        return grupo;
    }



    public List<Grupo> getAll() {
        List<Grupo> list = null;
        try {
            this.beging();
            System.out.println(getEntityManager());
            list =  getEntityManager().createNamedQuery("GruposQuery").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getCount() {
        int count = 0;
        try {
            this.beging();
            System.out.println(getEntityManager());
            count = getEntityManager().createNamedQuery("GruposQuery").getMaxResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
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

    public void addGruop(Grupo grupo) {
        this.beging();
        getEntityManager().persist(grupo);
        getEntityManager().getTransaction().commit();
        try{
            System.out.println("Grupo salvo com sucesso: "+ grupo.getId());
        }catch(Exception e){
            System.out.println("Grupo salvo não adicionado");
            e.printStackTrace();
        }
    }

}