package ru.bstu.iitus.vt41.kid.cw.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private Long id;
    private String title;
    private LocalDate release_date;
    private String cover;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "band", referencedColumnName = "id")
    private Band band;

    @ManyToMany
    @JoinTable(
            name = "album_genres",
            joinColumns = @JoinColumn(name="album_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    private List<Genre> genres;
    
    public Album() {

    }
}


/*
"id": 1,
        "title": "Альбом",
        "release_date": "2020-12-18",
        "cover": "http://localhost:8000/media/E%3A/git/labs_web/backend/media/Front_lNLPXFi.jpg",
        "rating": 4,
        "band": {
            "name": "Название"
        },
        "genres": [
            {
                "name": "Жанр 1"
            },
            {
                "name": "Жанр 2"
            }
        ]
 */
