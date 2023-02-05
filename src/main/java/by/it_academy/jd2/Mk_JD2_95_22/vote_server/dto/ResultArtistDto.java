package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.util.Objects;

public class ResultArtistDto {
    Integer numberArtist;
    Integer count;

    public ResultArtistDto(Integer numberArtist, Integer count) {
        this.numberArtist = numberArtist;
        this.count = count;
    }

    public Integer getNumberArtist() {
        return numberArtist;
    }

    public void setNumberArtist(Integer numberArtist) {
        this.numberArtist = numberArtist;
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
                "numberArtist=" + numberArtist +
                ", count=" + count +
                '}';
    }
}
