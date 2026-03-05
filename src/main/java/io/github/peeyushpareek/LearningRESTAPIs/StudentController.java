package io.github.peeyushpareek.LearningRESTAPIs;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public String welcome() {return "Welcome to the Student Management System";}

    private final StudentService studentService;
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<StudentDTO> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/id/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/name/{name}")
    public StudentDTO getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

//    @GetMapping("/student/character/{character}")
//    public List<StudentDTO> getStudentByNameContains(@PathVariable String character) {
//        return studentService.getStudentByNameContains(character);
//    }

    @GetMapping("/student/list")
    public List<StudentDTO> getStudentByNameContains(@RequestParam String nameContains) {
        return studentService.getStudentByNameContains(nameContains);
    }

    @GetMapping("/student/listWithout")
    public List<StudentDTO> getStudentsByNameNotContaining(@RequestParam String nameContains) {
        return studentService.getStudentsByNameNotContaining(nameContains);
    }

    @PostMapping("/student/add")
    public StudentDTO addStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @DeleteMapping("/tudent/delete")
    public StudentDTO delStudent(@RequestParam long id) {
        return studentService.delStudent(id);
    }

    @GetMapping("/student/olderthan/{age}")
    public List<StudentDTO> findByAgeGreaterThan(@PathVariable int age) {
        return studentService.findByAgeGreaterThan(age);
    }
}
