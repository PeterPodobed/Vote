package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtistsAdd {
    public ArtistsAdd (){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("tutorial");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Artists cat1 = new Artists("КиШ");
        Artists cat2 = new Artists("Рамштайн");
        Artists cat3 = new Artists("Моцарт");
        Artists cat4 = new Artists("Мот");
        Artists cat5 = new Artists("СалоДуха");
        Artists cat6 = new Artists("Крид");

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
