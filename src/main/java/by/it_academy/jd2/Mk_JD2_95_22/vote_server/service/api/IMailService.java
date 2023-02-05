package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Vote;

public interface IMailService {
    void sendMail(Vote vote);

    boolean validateMail(String email);
}
