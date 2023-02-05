package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultArtistDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultGenreDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;

import java.util.List;

public interface IResultVoteService {
    ResultVoteDto getResult();
    List<ResultArtistDto> getTopArtist();
    List<ResultGenreDto> getTopGenre();
}
