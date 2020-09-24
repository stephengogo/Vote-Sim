public class SimulationDriver {
    public static void main(String[] args) {
        Question simMCQ = new Question("MC");
        Student s1 = new Student("someid");
        s1.setAnswer("A");

        simMCQ.addStudentAnswer(s1);
    }
}
