package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailService implements IMailService {
    private static final String EMAIL_SENDER = "nomatut123@gmail.com";

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    final Properties properties = new Properties();
    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");

    public MailService() {

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.user", "nomatut123@gmail.com");
    }

    @Override
    public void sendMail(ResultVoteDto newVote) {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        if (validateMail(newVote.getEmail())) {
            System.out.println("The email address " + newVote.getEmail() + " is valid");
        } else {
            throw new IllegalArgumentException("Некорректный email. Проверьте правильность введенных данных");
        }

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(EMAIL_SENDER));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(newVote.getEmail()));

            StringBuilder stringBuilder = new StringBuilder();
            message.setSubject("Ваш голос принят.");

            stringBuilder.append("Вы проголосовали за исполнителя №: " + newVote.getArtist() + "\n");
            stringBuilder.append("Вы проголосовали за жанры №: " + newVote.getGenre() + "\n");
            stringBuilder.append("Вы оставили о себе следующее сообщение: " + newVote.getAbout() + ".\n");
            stringBuilder.append("Вы проголосовали " + newVote.getDt_create() + ".\n");
            message.setText(stringBuilder.toString());

            Transport tr = session.getTransport();
            tr.connect(null, "123");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

            System.out.println("Сообщение успешно отправлено!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean validateMail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
