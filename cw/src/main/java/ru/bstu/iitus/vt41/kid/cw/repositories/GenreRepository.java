package ru.bstu.iitus.vt41.kid.cw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bstu.iitus.vt41.kid.cw.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
