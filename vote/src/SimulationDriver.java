public class SimulationDriver {
    public static void main(String[] args) {
        //Question simMCQ = new Question("MC");
        Student s1 = new Student("someid");
        s1.setAnswer("A");

        //simMCQ.addStudentAnswer(s1);
        Question mcq = new Question("Multiple Choice", new String[]{"A", "B", "C", "D"}, new String[]{"C", "D"});

        VotingService vs = new VotingService(mcq);
        //vs.addStudentAnswer

        String[] test = {"1", "2"};
        System.out.println(test[1]); // prints 2
        System.out.println(mcq.answer_choices[1]);
        System.out.println(mcq.correct_answer[1]);
    }
}
