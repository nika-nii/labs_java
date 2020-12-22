package ru.bstu.iitus.vt41.fnr.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bstu.iitus.vt41.fnr.course.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
