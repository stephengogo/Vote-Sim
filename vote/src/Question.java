/**Stephen Lee*/

public class Question {
    public String[] answer_choices;
    public String[] correct_answer;
    public String question_type;
    //question_type can be used to right down the question

    /**Question Constructor */
    public Question(String qtype, String[] answerChoices, String[] correctAnswer){
        question_type = qtype;
        answer_choices = answerChoices;
        correct_answer = correctAnswer;
    }
}

