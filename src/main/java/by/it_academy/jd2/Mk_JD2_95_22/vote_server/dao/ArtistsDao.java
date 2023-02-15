package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IArtistsDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api.IManager;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Artists;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ArtistsDao implements IArtistsDao {
    private IManager iManager;
    private List<Artists> artists = new ArrayList<>();

    public List<Artists> getArtists() {
        return artists;
    }

    @Override
    public List<Artists> get() {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            artists = entityManager.createQuery("FROM Artists").getResultList();
            entityManager.getTransaction().commit();
            return artists;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public synchronized boolean add(String newArtist) {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new Artists(newArtist));
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
            Artists reference = entityManager.find(Artists.class, id);
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

        List<Artists> artistsList = get();
        for (Artists artists : artistsList) {
            if (id == artists.getId()) {
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
            Artists artistEntity = entityManager.find(Artists.class, id);
            entityManager.getTransaction().commit();
            return artistEntity != null;

        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
