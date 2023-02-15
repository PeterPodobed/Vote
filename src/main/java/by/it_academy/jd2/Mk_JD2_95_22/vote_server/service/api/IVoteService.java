package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Vote;

import java.util.List;

public interface IVoteService {
    void save(ResultVoteDto newVote);

    List<Vote> get();
}
