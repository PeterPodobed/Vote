package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api.IManager;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Vote;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class VoteDao implements IVoteDao {
    private IManager iManager;
    private List<Vote> voteList = new ArrayList<>();

    public List<Vote> getVoteList() {
        return voteList;
    }

    @Override
    public List<Vote> get() {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
            voteList = entityManager.createQuery("FROM Vote ").getResultList();
            entityManager.getTransaction().commit();
            return voteList;
        } catch (Exception e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean save(ResultVoteDto newVote) {
        EntityManager entityManager = null;
        try {
            entityManager = iManager.getEntityManager();
            entityManager.getTransaction().begin();
//            entityManager.persist(new Vote(newVote.getArtist(), newVote.getGenre(), newVote.getAbout(),
//                    newVote.getEmail(), newVote.getDt_create()));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("SQL exception", e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
