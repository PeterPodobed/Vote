package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IResultVoteService {
    public VoteFinalDto getResult();
    Map<ArtistsDto, Integer> getTopArtist();
    Map<GenresDto, Integer> getTopGenre();
    public Map<LocalDateTime, String> getAbout();
}
