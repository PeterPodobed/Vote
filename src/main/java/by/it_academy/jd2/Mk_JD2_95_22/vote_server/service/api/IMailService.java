package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;

public interface IMailService {
    void sendMail(ResultVoteDto vote);

    boolean validateMail(String email);
}
