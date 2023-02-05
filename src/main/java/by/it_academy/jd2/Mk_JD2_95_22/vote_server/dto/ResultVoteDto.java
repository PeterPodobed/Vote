package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;

import java.util.List;

public class ResultVoteDto {
    private List<ResultArtistDto> resultArtist;
    private List<ResultGenreDto> resultGenre;

    public ResultVoteDto(List<ResultArtistDto> resultArtist, List<ResultGenreDto> resultGenre) {
        this.resultArtist = resultArtist;
        this.resultGenre = resultGenre;
    }

    public List<ResultArtistDto> getResultArtist() {
        return resultArtist;
    }

    public void setResultArtist(List<ResultArtistDto> resultArtist) {
        this.resultArtist = resultArtist;
    }

    public List<ResultGenreDto> getResultGenre() {
        return resultGenre;
    }

    public void setResultGenre(List<ResultGenreDto> resultGenre) {
        this.resultGenre = resultGenre;
    }

    @Override
    public String toString() {
        return "ResultVoteDto{" +
                "resultArtist=" + resultArtist +
                ", resultGenre=" + resultGenre +
                '}';
    }
}
