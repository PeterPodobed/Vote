package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.Manager;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.orm.api.IManager;

public class ManagerSingleton {
    private volatile static IManager instance;

    private ManagerSingleton() {
    }

    public static IManager getInstance() {
        if (instance == null) {
            synchronized (ManagerSingleton.class){
                if(instance == null){
                    instance = new Manager();
                }
            }
        }
        return instance;
    }
}
