package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultVoteService implements IResultVoteService {
    private final String INQUIRY_ARTIST = "SELECT MAX(ARTIST) AS MAX,\n" +
            "\tCOUNT(ARTIST)\n" +
            "FROM VOTE\n" +
            "GROUP BY (ARTIST)\n" +
            "ORDER BY COUNT DESC\n" +
            "LIMIT 1";
    private final String INQUIRY_GENRE = "";
    private List<Artists> resultArtist = new ArrayList<>();
    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");

    @Override
    public ResultVoteDto getResult() {

        return null;
    }

    @Override
    public List<Artists> getTopArtist() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        resultArtist = entityManager.createQuery(INQUIRY_ARTIST).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return resultArtist;
    }

    @Override
    public List<Genres> getTopGenre() {
        return null;
    }
}
