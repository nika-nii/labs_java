package ru.bstu.iitus.vt41.fnr.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bstu.iitus.vt41.fnr.course.models.Element;
import ru.bstu.iitus.vt41.fnr.course.models.Tag;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
    List<Element> findElementByTags_Id(Long id);
    List<Element> findElementByName(String name);
}
