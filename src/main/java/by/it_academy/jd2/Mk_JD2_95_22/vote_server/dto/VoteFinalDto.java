package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;


import java.time.LocalDateTime;
import java.util.Map;

public class VoteFinalDto {
    private final Map<ArtistsDto, Integer> mapArtists;
    private final Map<GenresDto, Integer> mapGenres;
    private final Map<LocalDateTime, String> mapAbout;

    public VoteFinalDto(Map<ArtistsDto, Integer> mapArtists, Map<GenresDto, Integer> mapGenres,
                        Map<LocalDateTime, String> mapAbout) {
        this.mapArtists = mapArtists;
        this.mapGenres = mapGenres;
        this.mapAbout = mapAbout;
    }

    public Map<ArtistsDto, Integer> getMapArtists() {
        return mapArtists;
    }

    public Map<GenresDto, Integer> getMapGenres() {
        return mapGenres;
    }

    public Map<LocalDateTime, String> getMapAbout() {
        return mapAbout;
    }
}
