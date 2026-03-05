package io.github.peeyushpareek.LearningRESTAPIs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 30, message = "name can  be of length 3 to 30")
    private String name;

    @NotBlank(message = "age is required")
    @Min(value = 5, message = "new student age can not be less than 5 years")
    private int age;

}
