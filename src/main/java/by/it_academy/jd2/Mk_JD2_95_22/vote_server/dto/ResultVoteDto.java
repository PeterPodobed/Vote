package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ResultVoteDto {
    private long artist;
    private long[] genre;
    private String about;
    private String email;
    private LocalDateTime dt_create;

    public ResultVoteDto(long artist, long[] genre, String about, String email, LocalDateTime dt_create) {
        this.artist = artist;
        this.genre = genre;
        this.about = about;
        this.email = email;
        this.dt_create = dt_create;
    }

    public long getArtist() {
        return artist;
    }

    public long[] getGenre() {
        return genre;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setArtist(long artist) {
        this.artist = artist;
    }

    public void setGenre(long[] genre) {
        this.genre = genre;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    @Override
    public String toString() {
        return "ResultVoteDto{" +
                "artist=" + artist +
                ", genre=" + Arrays.toString(genre) +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", dt_create=" + dt_create +
                '}';
    }
}
