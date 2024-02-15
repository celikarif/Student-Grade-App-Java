package kodlama.StutdentGrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditStudentDto {
    private String name;

    private String familyName;

    private Integer midtermGrade;

    private Integer finalGrade;

    private String phoneNo;

    private String Address;

    private Integer Age;

    private Long id;

}
