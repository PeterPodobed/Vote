package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultArtistDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultGenreDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;
import org.postgresql.core.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class ResultVoteService implements IResultVoteService {
    private IVoteService voteService;
    private IArtistsService artistsService;
    private IGenresService genresService;

    private final String INQUIRY_ARTIST = "select max(artist), count(artist) as count from Vote group by artist " +
            "order by count desc limit 1";
    private final String INQUIRY_GENRE_1 = "select max (genre_1), count(genre_1) from Vote group by (genre_1)";
    private final String INQUIRY_GENRE_2 = "select max (genre_2), count(genre_2) from Vote group by (genre_2)";
    private final String INQUIRY_GENRE_3 = "select max (genre_3), count(genre_3) from Vote group by (genre_3)";
    private final String INQUIRY_GENRE_4 = "select max (genre_4), count(genre_4) from Vote group by (genre_4)";
    private final String INQUIRY_GENRE_5 = "select max (genre_5), count(genre_5) from Vote group by (genre_5)";

    private List<ResultArtistDto> resultArtist = new ArrayList<>();
    private List<ResultGenreDto> resultGenre = new ArrayList<>();

    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");

    public ResultVoteService(IVoteService voteService, IArtistsService artistsService, IGenresService genresService) {
        this.voteService = voteService;
        this.artistsService = artistsService;
        this.genresService = genresService;
    }

    @Override
    public ResultVoteDto getResult() {

        return new ResultVoteDto(getTopArtist(), getTopGenre());
    }

    @Override
    public List<ResultArtistDto> getTopArtist() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        resultArtist = entityManager.createQuery("select max(artist), count(artist) as count from Vote group by artist").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultArtist;
    }

    @Override
    public List<ResultGenreDto> getTopGenre() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        resultGenre.addAll(entityManager.createQuery(INQUIRY_GENRE_1).getResultList());
        resultGenre.addAll(entityManager.createQuery(INQUIRY_GENRE_2).getResultList());
        resultGenre.addAll(entityManager.createQuery(INQUIRY_GENRE_3).getResultList());
        resultGenre.addAll(entityManager.createQuery(INQUIRY_GENRE_4).getResultList());
        resultGenre.addAll(entityManager.createQuery(INQUIRY_GENRE_5).getResultList());

//        entityManager.getTransaction().commit();
        entityManager.close();
        return resultGenre;
    }
}
