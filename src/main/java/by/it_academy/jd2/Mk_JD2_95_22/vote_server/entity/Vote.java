package by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vote_artists",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private Artists artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vote_genres",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private List<Genres> genre = new ArrayList<>();
    private String about;
    private String email;
    private LocalDateTime dt_create;

    public Vote() {
    }

    public Vote(Artists artist, List<Genres> genre, String about, String email, LocalDateTime dt_create) {
        this.artist = artist;
        this.genre = genre;
        this.about = about;
        this.email = email;
        this.dt_create = dt_create;
    }

    public Vote(Vote newVote) {

    }

    public long getId() {
        return id;
    }

    public Artists getArtist() {
        return artist;
    }

    public List<Genres> getGenre() {
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


}
