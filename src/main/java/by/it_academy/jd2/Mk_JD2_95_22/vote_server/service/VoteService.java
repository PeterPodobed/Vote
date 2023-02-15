package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class VoteService implements IVoteService {
    private final IVoteDao dao;
    private final IArtistsService artistsService;
    private final IGenresService genresService;
    private final IMailService mailService;


    public VoteService(IVoteDao dao, IArtistsService artistsService, IGenresService genresService, IMailService mailService) {
        this.dao = dao;
        this.artistsService = artistsService;
        this.genresService = genresService;
        this.mailService = mailService;
    }

    @Override
    public List<Vote> get() {
        return this.dao.get();
    }

    @Override
    public void save(ResultVoteDto newVote) {
        check(newVote);

//        SavedVoiceDTO savedVoiceDTO = new SavedVoiceDTO(voice);
//
//        String email = savedVoiceDTO.getMail();
//        LocalDateTime creationTime = savedVoiceDTO.getCreationTime();
//        String message = savedVoiceDTO.getMessage();
//        long key = savedVoiceDTO.getKey();
//        boolean auth = savedVoiceDTO.isAuthorization();
//        long singer_id = savedVoiceDTO.getSinger();
//        SingerDTO s = singerService.get(singer_id);
//        Singer singer = new Singer(s.getId(), s.getName());
//
//        List<Genre> genres = new ArrayList<>();
//        for (long genre_id : savedVoiceDTO.getGenre()) {
//            GenreDTO genreDTO = genreService.get(genre_id);
//            genres.add(new Genre(genreDTO.getId(), genreDTO.getName()));
//        }
//
//        SavedVoice savedVoice = new SavedVoice(singer, genres, message, email, creationTime, key, auth);
//        long id = votingDao.save(savedVoice);
//        executorService.submit(new Thread(() -> mailService.send(savedVoice, id)));
//
//        this.dao.save(newVote);
//        mailService.sendMail(newVote);
    }

    private void check(ResultVoteDto vote) {
        long singer = vote.getArtist();
        if (!artistsService.numberArtist(vote.getArtist())) {
            throw new IllegalArgumentException("Артист №" + singer + " отсутствует в списке выбора");
        }

        long[] genres = vote.getGenre();

        Set<Long> setGenre = new HashSet<>();

        for (long val : genres) {
            setGenre.add(val);
        }

        if (setGenre.size() < 3 || setGenre.size() > 5) {
            throw new IllegalArgumentException("Неверное количество жанров, должно быть от 3 до 5");
        }

        if (setGenre.size() != genres.length) {
            throw new IllegalArgumentException("Переданные жанры содержат дубли");
        }

        for (Long genre : setGenre) {
            if (!genresService.numberGenre(genre)) {
                throw new IllegalArgumentException("Введенный жанр №" + genre + " не содержится в списке");
            }
        }

        String aboutMe = vote.getAbout();
        if (aboutMe == null || aboutMe.isBlank()) {
            throw new IllegalArgumentException("Нужно ввести информацию о себе");
        }

        String email = vote.getEmail();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|},~\\-]+(?:\\\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~\\-]+)*@+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?+\\.+[a-zA-Z]*$");
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("E-MAIL IS NOT CORRECT");
        }
    }
}
