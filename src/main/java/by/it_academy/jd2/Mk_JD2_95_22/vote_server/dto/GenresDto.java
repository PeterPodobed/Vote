package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.util.Objects;

public class GenresDto {
    private long id;
    private String nameGenre;

    public GenresDto(long id, String nameGenre) {
        this.id = id;
        this.nameGenre = nameGenre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresDto genresDto = (GenresDto) o;
        return id == genresDto.id && Objects.equals(nameGenre, genresDto.nameGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameGenre);
    }

    @Override
    public String toString() {
        return "GenresDto{" +
                "id=" + id +
                ", nameGenre='" + nameGenre + '\'' +
                '}';
    }
}
