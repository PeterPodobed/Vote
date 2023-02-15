package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api.IManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager implements IManager {
    private EntityManagerFactory factory;

    public Manager() {
        this.factory = Persistence.createEntityManagerFactory("tutorial");
    }

    public javax.persistence.EntityManager getEntityManager(){
        return this.factory.createEntityManager();
    }

    @Override
    public void close() {
        this.factory.close();
    }
}
