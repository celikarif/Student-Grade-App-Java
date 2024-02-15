package kodlama.StutdentGrade.repository;

import kodlama.StutdentGrade.entity.Student;
import kodlama.StutdentGrade.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository  extends PagingAndSortingRepository<StudentDetail, Long>, JpaRepository<StudentDetail, Long> {



}