package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api;

import javax.persistence.EntityManager;

public interface IManager {
    EntityManager getEntityManager();

    void close();
}
