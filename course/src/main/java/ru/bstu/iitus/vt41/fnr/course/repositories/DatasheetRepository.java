package ru.bstu.iitus.vt41.fnr.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bstu.iitus.vt41.fnr.course.models.Datasheet;
import ru.bstu.iitus.vt41.fnr.course.models.Element;

import java.util.List;

@Repository
public interface DatasheetRepository extends JpaRepository<Datasheet, String> {
}
