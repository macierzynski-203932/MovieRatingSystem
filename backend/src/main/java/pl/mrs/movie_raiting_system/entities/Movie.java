package pl.mrs.movie_raiting_system.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="movies")
public class Movie implements Serializable {

    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull
    private Long budget;

    @NotBlank
    @Type(type = "text")
    private String overview;


    private String poster_path;

    @NotBlank
    private String release_date;

    @NotBlank
    private String title;


    private Double vote_average;


    private int vote_count;
}
