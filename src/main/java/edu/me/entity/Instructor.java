package edu.me.entity;

import edu.me.util.CountryCode;
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
public class Instructor {
    @Id
    @GeneratedValue(generator = "instructor_id")
    @GenericGenerator(name="instructor_id",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 120)
    private UUID instructorId;
    @Column(unique = true,nullable = false,length = 120)
    private String nickname;
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
    @OneToMany(mappedBy = "instructor")
    private List<Course> taughtCourses;

    public void setIsoCountryCode(String isoCountryCode) throws InvalidPropertiesFormatException {
        if (!CountryCode.isIsoCountryCode(isoCountryCode))
            throw new InvalidPropertiesFormatException("Invalid iso country code");
        this.isoCountryCode = isoCountryCode;
    }
}
