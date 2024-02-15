package kodlama.StutdentGrade.service.impl;

import kodlama.StutdentGrade.dto.CreateStudentDto;
import kodlama.StutdentGrade.dto.EditStudentDto;
import kodlama.StutdentGrade.dto.GetAllStudentsDto;
import kodlama.StutdentGrade.dto.StudentDto;
import kodlama.StutdentGrade.entity.Student;
import kodlama.StutdentGrade.entity.StudentDetail;
import kodlama.StutdentGrade.mapper.MapperService;
import kodlama.StutdentGrade.repository.StudentDetailRepository;
import kodlama.StutdentGrade.repository.StudentRepository;
import kodlama.StutdentGrade.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentDetailRepository studentDetailRepository;
    private MapperService mapperService;
    @Override
    public List<GetAllStudentsDto> fetchAll() {

        List<Student> students = studentRepository.findAll();

        List<GetAllStudentsDto> getAllStudents = students.stream()
                        .map(student -> this.mapperService.forResponse()
                        .map(student, GetAllStudentsDto.class))
                        .collect(Collectors.toList());

        return getAllStudents;
    }

    @Override
    public StudentDto fetchById(Long id) {
        Student student = studentRepository.findById(id).get();

        return this.mapperService.forResponse().map(student , StudentDto.class);
    }

    @Override
    public void createStudent(CreateStudentDto createStudentDto) {

        StudentDetail studentDetail = new StudentDetail();

        studentDetail.setAddress(createStudentDto.getAddress());
        studentDetail.setPhoneNo(createStudentDto.getPhoneNo());
        studentDetail.setAge(createStudentDto.getAge());
        this.studentDetailRepository.save(studentDetail);

        createStudentDto.setLetterGrade(GradeConverter.letterGrade(createStudentDto.getMidtermGrade() , createStudentDto.getFinalGrade()));
        Student student = this.mapperService.forRequest().map(createStudentDto, Student.class);
        student.setStudentDetail(studentDetail);
        this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        this.studentRepository.delete(student);
        studentDetailRepository.delete(student.getStudentDetail());

    }

    @Override
    public void editStudent(EditStudentDto editStudentDto) {

        Student studentById = studentRepository.findById(editStudentDto.getId()).get();
        StudentDetail studentDetail = studentById.getStudentDetail();

        studentDetail.setPhoneNo(editStudentDto.getPhoneNo());
        studentDetail.setAge(editStudentDto.getAge());
        studentDetail.setAddress(editStudentDto.getAddress());
        this.studentDetailRepository.save(studentDetail);
        Student student = this.mapperService.forRequest().map(editStudentDto, Student.class);
        student.setStudentDetail(studentDetail);
        student.setLetterGrade(GradeConverter.letterGrade(editStudentDto.getMidtermGrade() , editStudentDto.getFinalGrade()));
        this.studentRepository.save(student);
    }

    @Override
    public List<GetAllStudentsDto> fetchAllSortedByName() {
        return studentRepository.findAll()
                .stream()
                .map(student -> mapperService.forResponse().map(student, GetAllStudentsDto.class))
                .sorted(Comparator.comparing(GetAllStudentsDto::getName))
                .collect(Collectors.toList());
    }


}
