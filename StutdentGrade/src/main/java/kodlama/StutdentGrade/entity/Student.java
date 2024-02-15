package kodlama.StutdentGrade.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "familyName")
    private String familyName;

    @Column(name = "midtermGrade")
    private Integer midtermGrade;

    @Column(name = "finalGrade")
    private Integer finalGrade;

    @Column(name = "letterGrade")
    private String letterGrade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_detail_id" , nullable = true)
    StudentDetail studentDetail;

}
