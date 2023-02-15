package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ArtistsDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Artists;

import java.util.List;

public interface IArtistsService {
    List<ArtistsDto> get();

    Artists get(long id);
    boolean add (String newArtist);

    boolean delete(long id);

    boolean exist(long id);

    boolean numberArtist (long number);


}
