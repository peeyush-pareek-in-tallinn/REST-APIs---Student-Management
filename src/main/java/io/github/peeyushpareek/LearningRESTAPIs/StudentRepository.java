package io.github.peeyushpareek.LearningRESTAPIs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByName(String name);

    List<StudentEntity> findByNameContaining(String character);

    List<StudentEntity> findByNameNotContaining(String character);

    List<StudentEntity> findByAgeGreaterThan(int age);

}
