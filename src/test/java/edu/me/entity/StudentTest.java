package edu.me.entity;

import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testInsertIsoCountryCode() throws InvalidPropertiesFormatException {
        // Arrange
        Student student = new Student();
        String isoCountryCode = "RW";

        // Act
        student.setIsoCountryCode(isoCountryCode);

        // Assert
        assertThat(student.getIsoCountryCode()).isEqualTo("RW");
    }

    @Test
    void testInsertWrongIsoCountryCode() {
        // Arrange
        Student student = new Student();
        String isoCountryCode = "wrongCode";

        // Act &Assert
        assertThrows(InvalidPropertiesFormatException.class,
                ()->student.setIsoCountryCode(isoCountryCode));
    }

}