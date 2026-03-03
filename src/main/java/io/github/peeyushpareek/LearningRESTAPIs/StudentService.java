package io.github.peeyushpareek.LearningRESTAPIs;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO getStudentByName(String name);

    List<StudentDTO> getStudentByNameContains(String character);

    List<StudentDTO> getStudentsByNameNotContaining(String character);

    StudentDTO addStudent(StudentDTO studentDTO);

    StudentDTO delStudent(long id);

    List<StudentDTO> findByAgeGreaterThan(int age);

}
