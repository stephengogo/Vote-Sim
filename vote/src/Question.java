import java.util.ArrayList;

public class Question {
    ArrayList<String> cars = new ArrayList<String>();
    public String[] student_ids;
    public String[] student_answers;
    public String[] answer_choices;
    public String[] correct_answer;

    public String question_type;

    public Question(String qtype, String[] answerChoices, String[] correctAnswer){
        question_type = qtype;
        answer_choices = answerChoices;
        correct_answer = correctAnswer;
        /*if(qtype.equals("Single Choice")){
            questionType = qtype;
        }
        else if (qtype.equals("Multiple Choice")){
            questionType = qtype;
        }*/
    }


}
