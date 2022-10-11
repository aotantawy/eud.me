package edu.me.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "course_id")
    @GenericGenerator(name="course_id",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 120)
    private UUID courseId;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private String requirements;
    @NotNull
    @NotBlank
    private String language;
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Student> enrolledStudents;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Instructor instructor;
}
