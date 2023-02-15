package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.*;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ResultVoteService implements IResultVoteService {
    private IVoteService voteService;
    private IArtistsService artistsService;
    private IGenresService genresService;


    public ResultVoteService(IVoteService voteService, IArtistsService artistsService, IGenresService genresService) {
        this.voteService = voteService;
        this.artistsService = artistsService;
        this.genresService = genresService;
    }

    @Override
    public VoteFinalDto getResult() {
        return new VoteFinalDto(getTopArtist(), getTopGenre(), getAbout());
    }

    @Override
    public Map<ArtistsDto, Integer> getTopArtist() {
        Map<ArtistsDto, Integer> mapArtist = new HashMap<>();
        List<ArtistsDto> artistsDtos = artistsService.get();
        for (ArtistsDto artist : artistsDtos) {
            mapArtist.put(artist, 0);
        }
        List<ResultVoteDto> resultVoteDtoList = voteService.get();
        for (ResultVoteDto resultVoteDto : resultVoteDtoList) {
            long idArtist = resultVoteDto.getArtist();
            for (ArtistsDto artistsDto : artistsDtos) {
                if (idArtist == artistsDto.getId()) {
                    mapArtist.put(artistsDto, mapArtist.get(artistsDto) + 1);
                }
            }
        }
        return mapArtist.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }

    @Override
    public Map<GenresDto, Integer> getTopGenre() {
        Map<GenresDto, Integer> mapGenre = new HashMap<>();
        List<GenresDto> genreDTOS = genresService.get();

        for (GenresDto genreDTO : genreDTOS) {
            mapGenre.put(genreDTO, 0);
        }
        List<ResultVoteDto> resultVoteDtos = voteService.get();
        for (ResultVoteDto resultVoteDto : resultVoteDtos) {
            long[] idGenre = resultVoteDto.getGenre();
            for (GenresDto genreDTO : genreDTOS) {
                for (long i : idGenre) {
                    if (i == genreDTO.getId()) {
                        mapGenre.put(genreDTO, mapGenre.get(genreDTO) + 1);
                    }
                }
            }
        }
        return mapGenre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }
    @Override
    public Map<LocalDateTime, String> getAbout(){
        List<ResultVoteDto> resultVoteDtos = voteService.get();
        Map<LocalDateTime, String> mapUser = new HashMap<>();
        for (ResultVoteDto resultVoteDto : resultVoteDtos) {
            mapUser.put(resultVoteDto.getDt_create(), resultVoteDto.getAbout());
        }
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder(LocalDateTime::compareTo)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }

}
