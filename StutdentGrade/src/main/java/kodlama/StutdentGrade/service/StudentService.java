package kodlama.StutdentGrade.service;

import kodlama.StutdentGrade.dto.CreateStudentDto;
import kodlama.StutdentGrade.dto.EditStudentDto;
import kodlama.StutdentGrade.dto.GetAllStudentsDto;
import kodlama.StutdentGrade.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<GetAllStudentsDto> fetchAll();

    StudentDto fetchById(Long id);

    void createStudent(CreateStudentDto createStudentDto);

    void deleteStudent(Long id );

    void editStudent(EditStudentDto editStudentDto);

    List<GetAllStudentsDto> fetchAllSortedByName();


}
