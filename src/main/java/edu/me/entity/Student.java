package edu.me.entity;

import edu.me.util.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(generator = "student_id")
    @GenericGenerator(name="student_id",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 120)
    private UUID studentId;
    @Column(unique = true,nullable = false,length = 120)
    private String nickName;
    @NotNull
    @NotBlank
    private String fullName;
    @NotNull
    @NotBlank
    private String address;
    @Past
    private LocalDate birthday;
    @NotNull
    @NotBlank
    private String isoCountryCode;
    @ManyToMany
    @JoinTable(
            name = "student_enrolled_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;

    public void setIsoCountryCode(String isoCountryCode) throws InvalidPropertiesFormatException {
        if (!CountryCode.isIsoCountryCode(isoCountryCode))
            throw new InvalidPropertiesFormatException("Invalid iso country code");
        this.isoCountryCode = isoCountryCode;
    }
}
