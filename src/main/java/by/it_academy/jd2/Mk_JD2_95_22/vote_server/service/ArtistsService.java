package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IArtistsDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ArtistsDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;

import java.util.ArrayList;
import java.util.List;

public class ArtistsService implements IArtistsService {
    private final IArtistsDao dao;

    public ArtistsService(IArtistsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ArtistsDto> get() {
        List<Artists> artistsList = dao.get();

        List<ArtistsDto> list = new ArrayList<>();

        for (Artists artists : artistsList) {
            list.add(new ArtistsDto(artists.getId(), artists.getNameArtist()));
        }

        return list;
    }

    @Override
    public Artists get(long id) {
        List<Artists> artists = this.dao.get();
        for (Artists art : artists){
            if (id == art.getId()){
                return art;
            }
        }
        return null;
    }

    @Override
    public boolean add(String newArtist) {
        return dao.add(newArtist);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }

    @Override
    public boolean exist(long id) {
        List<Artists> artists = this.dao.get();
        for (Artists art : artists){
            if (id == art.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean numberArtist(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Введите номер исполнителя");
        }
        return this.dao.isContain(number);
    }
}
