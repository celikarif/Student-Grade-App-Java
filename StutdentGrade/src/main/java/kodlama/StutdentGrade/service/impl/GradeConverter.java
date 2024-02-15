package kodlama.StutdentGrade.service.impl;

import java.util.*;

public class GradeConverter {
    private static final TreeMap<Integer, String> gradeMap = new TreeMap<>();


    static {
        gradeMap.put(90, "AA");
        gradeMap.put(85, "BA");
        gradeMap.put(80, "BB");
        gradeMap.put(75, "CB");
        gradeMap.put(70, "CC");
        gradeMap.put(65, "DC");
        gradeMap.put(60, "DD");
       }

    public static String letterGrade(int midtermGrade, int finalGrade) {

        int totalGrade = (int) (midtermGrade * 0.4 + finalGrade * 0.6);
         for (int grade : gradeMap.descendingKeySet()) {
            if (totalGrade >= grade) {
                return gradeMap.get(grade);
            }
        }
        return "FF";
    }

}
