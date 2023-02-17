//package xyz.zapgrupos.services;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import xyz.zapgrupos.model.Grupo;
//
//public class GruposDAO implements GruposService{
//    @Override
//    public void addGroup(Grupo grupo) {
//        try(Session session = Service.getSession()){
//            Transaction tx = session.getTransaction();
//            session.save(grupo);
//            tx.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void updateGroup(Grupo grupo ) {
//
//    }
//}
