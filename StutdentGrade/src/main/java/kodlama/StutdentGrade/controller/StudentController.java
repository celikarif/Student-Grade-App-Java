package kodlama.StutdentGrade.controller;

import kodlama.StutdentGrade.dto.CreateStudentDto;
import kodlama.StutdentGrade.dto.EditStudentDto;
import kodlama.StutdentGrade.dto.GetAllStudentsDto;
import kodlama.StutdentGrade.dto.StudentDto;
import kodlama.StutdentGrade.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<GetAllStudentsDto> fetchAll() {
        return  this.studentService.fetchAll();
    }


    @GetMapping("/byid")
    public StudentDto fetchByID(@RequestParam("id") Long id) {
        return  this.studentService.fetchById(id);
    }

    @PostMapping()
    public void createStudent(@RequestBody CreateStudentDto createStudentDto) {
        this.studentService.createStudent(createStudentDto);
    }

    @PutMapping()
    public void editStudent(@RequestBody EditStudentDto editStudentDto) {
            this.studentService.editStudent(editStudentDto);
    }

    @DeleteMapping()
    public void deleteStudent(@RequestParam("id") Long id) {
        this.studentService.deleteStudent(id);
    }

    @GetMapping("/sortbyname")
    public List<GetAllStudentsDto> fetchAllSortedByName() {
        return studentService.fetchAllSortedByName();
    }


}
