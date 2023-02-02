package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;

import java.util.List;

public interface IResultVoteService {
    ResultVoteDto getResult();
    List<Artists> getTopArtist();
    List<Genres> getTopGenre();
}
