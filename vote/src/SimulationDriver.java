import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;


public class SimulationDriver {
    public static void main(String[] args) {
        /** Simulate Multiple Choice question */
        String[] mcq_answer_choices = {"A", "B", "C", "D"};
        String[] mcq_answer = {"C", "D"};
        Question mcq = new Question("Multiple Choice", mcq_answer_choices, mcq_answer);

        VotingService vs_mcq = new VotingService(mcq);

        /**Generate Student IDs */
        String alphabet_numbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int alp_size = alphabet_numbers.length();
        ArrayList<String> student_ids_arrlist = new ArrayList<String>();
        int number_of_students = 20;

        Random random = new Random();
        while(student_ids_arrlist.size() < number_of_students){
            StringBuilder sb = new StringBuilder();

            while(sb.length() < 7){
                int randInt = random.nextInt(alp_size);
                char randChar = alphabet_numbers.charAt(randInt);
                sb.append(randChar);
            }

            if(!student_ids_arrlist.contains(sb.toString())){
                student_ids_arrlist.add(sb.toString());
            }
        }

        for (int i = 0; i < number_of_students; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mcq_answer_choices.length; j++) {
                // random number between [0 - 1]
                int rand_int = random.nextInt(2);

                if(rand_int == 1){
                    sb.append(mcq_answer_choices[j]);
                }
            }
            // in Case of 0000
            if(sb.length() == 0){
                // random number between [0-3]
                int rand_int = random.nextInt(mcq_answer_choices.length - 1);
                sb.append(mcq_answer_choices[rand_int]);
            }
            //System.out.println(sb);

            //System.out.println(student_ids_arrlist.get(i));
            Student s = new Student(student_ids_arrlist.get(i), sb.toString());
            System.out.println(s.getId() + " " + s.getAnswer());
            vs_mcq.addStudentAnswer(s);
        }

        /**Print Mult Choice stats */
        vs_mcq.printStatistics();



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
