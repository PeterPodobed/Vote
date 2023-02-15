package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.util.Objects;

public class ArtistsDto {
    private long id;
    private String nameArtist;

    public ArtistsDto(long id, String nameArtist) {
        this.id = id;
        this.nameArtist = nameArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistsDto that = (ArtistsDto) o;
        return id == that.id && Objects.equals(nameArtist, that.nameArtist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameArtist);
    }

    @Override
    public String toString() {
        return "ArtistsDto{" +
                "id=" + id +
                ", nameArtist='" + nameArtist + '\'' +
                '}';
    }
}
