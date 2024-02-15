package kodlama.StutdentGrade.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentsDto {

    private Long id;

    private String name;

    private String familyName;

    private Integer midtermGrade;

    private Integer finalGrade;

    private String letterGrade;

    private Long detailId;

}
