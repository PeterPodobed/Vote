package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.VoteDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.ResultVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.VoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

public class ResultVoteServiceSingleton {
    private volatile static ResultVoteService instance;

    private ResultVoteServiceSingleton() {
    }

    public static IResultVoteService getInstance() {
        if(instance == null){
            synchronized (ResultVoteServiceSingleton.class){
                if(instance == null){
                    instance = new ResultVoteService(
                            VoteServiceSingleton.getInstance(),
                            ArtistsServiceSingleton.getInstance(),
                            GenresServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}
