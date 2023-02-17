//package xyz.zapgrupos.services;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public class Service {
//    private static final Service instance = new Service();
//    private SessionFactory factory;
//    public Service() {
//        initialize();
//    }
//
//    public static Session getSession() {
//        return getInstance().factory.openSession();
//    }
//
//    public static void forceReload() {
//        getInstance().initialize();
//    }
//
//    private static Service getInstance() {
//        return instance;
//    }
//
//    private void initialize() {
//        StandardServiceRegistry registry =
//                new StandardServiceRegistryBuilder()
//                        .configure()
//                        .build();
//        factory = new MetadataSources(registry)
//                .buildMetadata()
//                .buildSessionFactory();
//    }
//    //end::preamble[]
//
//    public static void doWithSession(Consumer<Session> command) {
//        try (Session session = getSession()) {
//            Transaction tx = session.beginTransaction();
//
//            command.accept(session);
//            if (tx.isActive() &&
//                    !tx.getRollbackOnly()) {
//                tx.commit();
//            } else {
//                tx.rollback();
//            }
//        }
//    }
//
//    public static <T> T returnFromSession(Function<Session, T> command) {
//        try (Session session = getSession()) {
//            Transaction tx = null;
//            try {
//                tx = session.beginTransaction();
//
//                return command.apply(session);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            } finally {
//                if (tx != null) {
//                    if (tx.isActive() &&
//                            !tx.getRollbackOnly()) {
//                        tx.commit();
//                    } else {
//                        tx.rollback();
//                    }
//                }
//            }
//        }
//    }
//}