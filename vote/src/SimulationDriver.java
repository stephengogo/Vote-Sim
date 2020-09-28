/**Stephen Lee*/

import java.util.Random;
import java.util.ArrayList;

public class SimulationDriver {
    public static void main(String[] args) {
        /** Simulate Multiple Choice question */
        String[] mcq_answer_choices = {"A", "B", "C", "D"};
        String[] mcq_answer = {"C", "D"};
        Question mcq = new Question("Multiple Choice Example", mcq_answer_choices, mcq_answer);

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

        System.out.println("Print " + number_of_students + " Student ID and Answer: ");

        /** Take the generated Student IDs and allow students to answer the multiple choice question at Random*/
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


            Student s = new Student(student_ids_arrlist.get(i), sb.toString());
            System.out.println("Student ID: "+ s.getId() + ", Student Answer: " + s.getAnswer());

            vs_mcq.addStudentAnswer(s);
        }

        System.out.println("\nMultiple Choice Question Statistics: ");

        /**Print Mult Choice stats */
        vs_mcq.printStatistics();


        /** Simulate Single Choice question */
        String[] scq_answer_choices = {"A", "B", "C", "D"};
        String[] scq_answer = {"B"};
        Question scq = new Question("Single Choice Example", scq_answer_choices, scq_answer);
        VotingService vs_scq = new VotingService(scq);

        System.out.println("\nPrint " + number_of_students + " Student ID and Answer: ");

        /**Reuse pre-generated student Ids and fill them with single choice answers at random */
        for (int i = 0; i < number_of_students; i++) {
            StringBuilder sb = new StringBuilder();

            int rand_int = random.nextInt(scq_answer_choices.length);
            sb.append(scq_answer_choices[rand_int]);

            Student s = new Student(student_ids_arrlist.get(i), sb.toString());
            System.out.println("Student ID: "+ s.getId() + ", Student Answer: " + s.getAnswer());

            vs_scq.addStudentAnswer(s);
        }

        System.out.println("\nSingle Choice Question Statistics: ");

        /**Print Single Choice stats */
        vs_scq.printStatistics();


        /** Simulate True/False question */
        String[] tfq_answer_choices = {"True", "False"};
        String[] tfq_answer = {"True"};
        Question tfq = new Question("True False Example", tfq_answer_choices, tfq_answer);
        VotingService tfq_scq = new VotingService(tfq);

        System.out.println("\nPrint " + number_of_students + " Student ID and Answer: ");

        /**Reuse pre-generated student Ids and fill them with T/F answers at random */
        for (int i = 0; i < number_of_students; i++) {
            StringBuilder sb = new StringBuilder();

            int rand_int = random.nextInt(tfq_answer_choices.length);
            sb.append(tfq_answer_choices[rand_int]);

            Student s = new Student(student_ids_arrlist.get(i), sb.toString());
            System.out.println("Student ID: "+ s.getId() + ", Student Answer: " + s.getAnswer());

            /**Test to Check if Student Changes Answer it does not change it. It Works*/
            /*if(i == number_of_students - 1){
                Student s1 = new Student(student_ids_arrlist.get(i), "False");
                tfq_scq.addStudentAnswer(s1);

                Student s2 = new Student(student_ids_arrlist.get(i), "True");
                tfq_scq.addStudentAnswer(s2);

                System.out.println("Student ID: "+ s1.getId() + ", Student Answer: " + s2.getAnswer());
                System.out.println("Student ID: "+ s1.getId() + ", Student Answer: " + s2.getAnswer());
            }*/

            tfq_scq.addStudentAnswer(s);
        }

        System.out.println("\nTrue/False Question Statistics: ");

        /**Print Single Choice stats */
        tfq_scq.printStatistics();


    }
}
