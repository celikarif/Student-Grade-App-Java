package kodlama.StutdentGrade.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id" ,  unique = true, nullable = false)
    private Long id;

    private String phoneNo;

    private String address;

    private Integer age;


    /*
      @JsonBackReference
    @OneToOne(mappedBy = "studentDetail")
    private Student student;
     */



}

