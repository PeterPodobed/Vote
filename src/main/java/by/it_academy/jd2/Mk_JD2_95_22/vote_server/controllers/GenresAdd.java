package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenresAdd {
    public GenresAdd(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("tutorial");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Genres cat1 = new Genres("Рок");
        Genres cat2 = new Genres("Классика");
        Genres cat3 = new Genres("Джаз");
        Genres cat4 = new Genres("Попса");
        Genres cat5 = new Genres("Хоп");
        Genres cat6 = new Genres("Раста");

        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);
        entityManager.persist(cat4);
        entityManager.persist(cat5);
        entityManager.persist(cat6);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
