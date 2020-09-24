import java.util.ArrayList;

public class Question {
    ArrayList<String> cars = new ArrayList<String>();
    public String[] student_ids;
    public String[] student_answers;
    public String questionType;

    public Question(String qtype){
        if(qtype.equals("MC")){
            questionType = qtype;
        }
        else if (qtype.equals("R/W")){
            questionType = qtype;
        }
    }

    public void addStudentAnswer(Student student){
        if(questionType.equals("MC")){
            if (student.getAnswer().equals("A") || student.getAnswer().equals("B") || student.getAnswer().equals("C") || student.getAnswer().equals("D")){
                System.out.println("Acceptable answer");
            }

        }
    }
}
