package io.github.peeyushpareek.LearningRESTAPIs;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service //Will write business logic here | This will talk to the persistence layer
@RequiredArgsConstructor //Shortcut to creating a constructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    // Find "All" students in the database and display them 2 records per page
    @Override
    public List<StudentDTO> getAllStudents() {
        Page<StudentEntity> studentEntityList = studentRepository.findAll(PageRequest.of(0, 2));
        return studentEntityList
                .stream()
                .map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge()))
                .toList();
    }

    // Find student with a particular ID
    public StudentDTO getStudentById(Long id) {
        StudentEntity student =  studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student Not Found"));
        return new StudentDTO(student.getId(), student.getName(), student.getAge());
    }

    // Find student with a particular name
    public StudentDTO getStudentByName(String name) {
        StudentEntity student = studentRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Record Not found"));
        StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getAge());
        return studentDTO;
    }

    // Find all students with their names containing a particular character
    @Override
    public List<StudentDTO> getStudentByNameContains(String character) {
        List<StudentEntity> studentEntityList = studentRepository.findByNameContaining(character);

        if(studentEntityList.isEmpty()) {
            throw new NoSuchElementException("No Student found with name containing '" + character + "'!");
        }

        List<StudentDTO> studentDTOList = new ArrayList<>();

        // Creating studentDTOList from studentEntityList, using a for loop
//        for (StudentEntity studentEntity : studentEntityList)
//            studentDTOList.add(new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge()));

        // Creating studentDTOList from studentEntityList, using a stream() operation
        studentDTOList = studentEntityList
                .stream()
                .map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge()))
                .toList();

        return studentDTOList;
    }

    // Find all students with their names NOT containing a particular character
    public List<StudentDTO> getStudentsByNameNotContaining(String character) {
        List<StudentEntity> studentEntityList = studentRepository.findByNameNotContaining(character);

        List<StudentDTO> finalList = studentEntityList
                .stream()
                .map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge()))
                .toList();
        return finalList;
    }

    // Add a new student to the database
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        StudentEntity newStudent = new StudentEntity();
//        newStudent.setId(studentDTO.getId());
        newStudent.setName(studentDTO.getName());
        newStudent.setAge(studentDTO.getAge());

        StudentEntity dto = studentRepository.save(newStudent);
        System.out.println("New Student record created:");
        return new StudentDTO(dto.getId(), dto.getName(), dto.getAge());

//        StudentEntity newStudent = modelMapper.map(addStudentRequestDTO, StudentEntity.class);
//        StudentEntity studentEntity = studentRepository.save(newStudent);
//        return modelMapper.map(studentEntity, StudentDTO.class);
    }

    // Delete a student to the database
    public StudentDTO delStudent(long id) {
        StudentEntity studentToDel = studentRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + id));

//        if (!studentRepository.existsById(id)) {
//            throw new NoSuchElementException("No Student found with ID: " + id);
//        }

        studentRepository.delete(studentToDel);
        System.out.println("Deleted from Database:");
        return new StudentDTO(studentToDel.getId(), studentToDel.getName(), studentToDel.getAge());
    }

    // Find all students above a given age
    @Override
    public List<StudentDTO> findByAgeGreaterThan(int age) {
        List<StudentEntity> studentList = studentRepository.findByAgeGreaterThan(age);
        if (studentList.isEmpty()) {
            throw new NoSuchElementException("No Student found older than " + age + " years of age!");
        }
        List<StudentDTO> finalStudentList = studentList.stream()
                .map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAge()))
                .toList();
        return finalStudentList;
    }
}
