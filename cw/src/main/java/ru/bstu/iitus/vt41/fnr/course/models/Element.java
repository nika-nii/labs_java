package ru.bstu.iitus.vt41.fnr.course.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@AllArgsConstructor
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_id")
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "element_tag",
            joinColumns = @JoinColumn(name="element_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private List<Tag> tags;

    public Element() {

    }
}