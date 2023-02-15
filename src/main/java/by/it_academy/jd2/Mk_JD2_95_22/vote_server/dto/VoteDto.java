package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.time.LocalDateTime;

public class VoteDto {
    public static class VoteBuilder {
        private long artist;
        private long[] genres;
        private String about;
        private String email;
        private LocalDateTime dt_create;

        private VoteBuilder() {
        }

        public VoteBuilder(long artist, long[] genres, String about, String email, LocalDateTime dt_create) {
            this.artist = artist;
            this.genres = genres;
            this.about = about;
            this.email = email;
            this.dt_create = dt_create;
        }

        public static VoteBuilder create() {
            return new VoteBuilder();
        }

        public long getArtist() {
            return artist;
        }

        public long[] getGenres() {
            return genres;
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

        public VoteBuilder setArtist(long artist) {
            this.artist = artist;
            return this;
        }

        public void setGenres(long[] genres) {
            this.genres = genres;
        }

        public VoteBuilder setAbout(String about) {
            this.about = about;
            return this;
        }

        public VoteBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public VoteBuilder setDt_create(LocalDateTime dt_create) {
            this.dt_create = dt_create;
            return this;
        }

//        public Vote build() {
//            return new Vote(artist, genres, about, email, dt_create);
//        }
    }

}
