package xyz.zapgrupos.model;

import org.bson.types.ObjectId;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class GrupoDAO{
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("default");
            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entityManager;
    }


    public Grupo update(EntityManager entityManager, Grupo grupo) throws  NoSuchFieldException, IllegalAccessException {
        Grupo ng = this.consultarPorId(grupo.getId());

        Field[] fields = Arrays.stream(grupo.getClass().getFields()).filter(
                e -> (e.getModifiers() == Modifier.PUBLIC)
        ).toArray(Field[]::new);

        for (Field prop: fields) {
            String field = prop.getName();
                System.out.println(String.format("--------------------------------------------------------------------------------------------------------------------------------"));
                var oldValue = ng.getClass().getField(field).get(ng);
                var newValue = grupo.getClass().getField(field).get(grupo);
                if((oldValue == newValue) | newValue == null) {
                    new Log("O valor do '%s' são iguais em ng:%s e grupo: %s", field, oldValue,  newValue);
                } else {
                    new Log("O valor do '%s' são diferentes em ng:%s e grupo: %s", field,  oldValue,  newValue);
                    ng.getClass().getField(prop.getName()).set(ng,newValue);
                    new Log("[MODIFICADO] O valor do %s são diferentes em grupo:%s e ng: %s", field,  newValue,  oldValue);
                }
        }
        entityManager.merge(ng);
        entityManager.flush();
        return ng;
    }

    public Grupo salvar(Grupo grupo) throws Exception {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (grupo.getId() == null) {
                entityManager.persist(grupo);
            } else {
                grupo = this.update(entityManager, grupo);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return grupo;
    }

    public List <Grupo> getAll() {
        EntityManager entityManager = getEntityManager();
        List <Grupo> list = null;
        try {
            entityManager.getTransaction().begin();
            Grupo s = (Grupo) entityManager.createQuery("SELECT g.id, g.titulo FROM Grupo where ativo = :ativo").getSingleResult();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return list;
    }

    /**
     * Método que apaga a pessoa do banco de dados.
     * @param id
     */
    public void excluir(String id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            /* Consulta a pessoa na base de dados através
              do seu ID. */
            Grupo grupo = consultarPorId(id);
            System.out.println("Excluindo a pessoa: " +
                    grupo.getTitulo());

            // Remove a pessoa da base de dados.
            entityManager.remove(grupo);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Consulta o pessoa pelo ID.
     * @param id
     * @return o objeto Pessoa.
     */
    public Grupo consultarPorId(String id) {
        EntityManager entityManager = getEntityManager();
        Grupo grupo = entityManager.find(Grupo.class, id);
        System.out.println("rumrmu: " + grupo.getId());
        try {
            if (grupo == null) {
                System.out.println("NÃO ENCONTRADO");
                return grupo;
            }
        } finally {
            entityManager.close();
        }
        return grupo;
    }
}