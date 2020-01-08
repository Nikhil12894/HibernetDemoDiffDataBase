package com.logicbig.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExampleMain2 {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("exampleunit");
        try {
            persistEntity(emf);
            runNativeQuery(emf);
            loadEntity(emf);
        } finally {
            emf.close();
        }
    }

    private static void persistEntity(EntityManagerFactory emf) throws Exception {
        EntityManager em = emf.createEntityManager();
        Report report = new Report();
        report.setData("{\"paramJson\":{\"appName\":\"ATSService\",\"alertCentralMap\":{\"casAPIKey\":\"8gBICuKvc3ZGNY8MkvXj\",\"casUrl\":\"https://ats.ersaltametrics.com/AlertDashboard/api/alert/create\",\"sendAlertToCAS\":false}}}");
        System.out.println("-- Persisting entity --");
        System.out.println(report);

        em.getTransaction().begin();
        em.persist(report);
        em.getTransaction().commit();
        em.close();
    }

    private static void runNativeQuery(EntityManagerFactory emf) {
        System.out.println("-- Native query --");
        EntityManager em = emf.createEntityManager();
        ExampleMain.nativeQuery(em, "Select * from REPORT");
    }

    private static void loadEntity(EntityManagerFactory emf) {
        System.out.println("-- Loading entity --");
        EntityManager em = emf.createEntityManager();
        List<Report> entityAList = em.createQuery("Select t from Report t").getResultList();
        entityAList.forEach(System.out::println);
        em.close();
    }
}