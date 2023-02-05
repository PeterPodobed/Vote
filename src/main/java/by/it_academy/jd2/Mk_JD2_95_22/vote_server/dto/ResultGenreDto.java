package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.util.Objects;

public class ResultGenreDto {
    Integer numberGenre;
    Integer count;

    public ResultGenreDto(Integer numberGenre, Integer count) {
        this.numberGenre = numberGenre;
        this.count = count;
    }

    public Integer getNumberGenre() {
        return numberGenre;
    }

    public void setNumberGenre(Integer id) {
        this.numberGenre = numberGenre;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "ResultArtistDto{" +
                "numberGenre=" + numberGenre +
                ", count=" + count +
                '}';
    }
}
