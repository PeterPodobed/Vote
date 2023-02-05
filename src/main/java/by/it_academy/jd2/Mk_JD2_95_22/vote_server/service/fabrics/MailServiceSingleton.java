package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.MailService;

public class MailServiceSingleton {
    private volatile static MailService instance;

    private MailServiceSingleton() {}

    public static MailService getInstance() {
        if(instance == null){
            synchronized (MailServiceSingleton.class){
                if(instance == null){
                    instance = new MailService();
                }
            }
        }
        return instance;
    }
}
