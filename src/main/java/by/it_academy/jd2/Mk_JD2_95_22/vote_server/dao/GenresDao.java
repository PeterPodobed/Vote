package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IGenresDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api.IManager;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Genres;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class GenresDao implements IGenresDao {
    private IManager iManager;
    private List<Genres> genres = new ArrayList<>();

    public List<Genres> getGenres() {
        return genres;
    }

    @Override
    public List<Genres> get() {

        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            genres = entityManager.createQuery("FROM Genres ").getResultList();
            entityManager.getTransaction().commit();
            return genres;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public synchronized boolean add(String newGenres) {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new Genres(newGenres));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public synchronized boolean delete(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            Genres reference = entityManager.find(Genres.class, id);
            if (reference == null) {
                throw new NullPointerException("Delete is not possible. The singer wasn't found in the database");
            }
            entityManager.remove(reference);
            entityManager.getTransaction().commit();
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean exist(long id) {
        EntityManager entityManager = null;
        entityManager = iManager.getEntityManager();
        entityManager.getTransaction().begin();

        List<Genres> genresList = get();
        for (Genres genres : genresList) {
            if (id == genres.getId()) {
                return true;
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public boolean isContain(long id) {

        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            Genres genreEntity = entityManager.find(Genres.class, id);
            entityManager.getTransaction().commit();
            return genreEntity != null;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
