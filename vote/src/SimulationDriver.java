import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;


public class SimulationDriver {
    public static void main(String[] args) {
        //Question simMCQ = new Question("MC");
        Student s1 = new Student("someid");
        s1.setAnswer("A");

        //simMCQ.addStudentAnswer(s1);

        /** Simulate Multiple Choice question */
        String[] mcq_answer_choices = {"A", "B", "C", "D"};
        String[] mcq_answer = {"C", "D"};
        Question mcq = new Question("Multiple Choice", mcq_answer_choices, mcq_answer);

        /**Generate Student IDs */
        String alphabet_numbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //String alphabet_numbers = "ABC";
        int alp_size = alphabet_numbers.length();

        ArrayList<String> student_ids = new ArrayList<String>();
        while(student_ids.size() < 20){
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            while(sb.length() < 7){
                int randInt = random.nextInt(alp_size);
                char randChar = alphabet_numbers.charAt(randInt);
                sb.append(randChar);
            }

            if(!student_ids.contains(sb.toString())){
                student_ids.add(sb.toString());
            }
        }
        for (int i = 0; i < 20; i++) {

        }



        VotingService vs_mcq = new VotingService(mcq);
        vs_mcq.printStatistics();
        //vs.addStudentAnswer

        /** Simulate Single Choice question */
        String[] scq_answer_choices = {"A", "B", "C", "D"};
        String[] scq_answer = {"B"};
        Question scq = new Question("Single Choice", scq_answer_choices, scq_answer);

        VotingService vs_scq = new VotingService(scq);

        /** Simulate True/False question */
        String[] tfq_answer_choices = {"True", "False"};
        String[] tfq_answer = {"True"};
        Question tfq = new Question("True False", tfq_answer_choices, tfq_answer);




        // some tests...
        String[] test = {"1", "2"};
        String[] test2 = {"2", "1"};
        if(Arrays.equals(test, test2)){
            // no because order is wrong
            System.out.println("they are equal");
        }
    }
}
