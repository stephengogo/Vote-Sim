import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VotingService {

    public Question q;
    public HashMap<String, String> id_answer = new HashMap<String, String>();

    public VotingService(Question q){
        this.q = q;
    }

    public void addStudentAnswer(Student student){
        /*if(question_type.equals("MC")){
            if (student.getAnswer().equals("A") || student.getAnswer().equals("B") || student.getAnswer().equals("C") || student.getAnswer().equals("D")){
                System.out.println("Acceptable answer");
            }

        }*/
    }

    public void printStatistics(){
        System.out.println("Correct answer is " + Arrays.toString(this.q.correct_answer));
    }

    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<String, String>();
        HashSet<String> hset = new HashSet<String>();

        test.put("as234s", "A");
        test.put("sadf", "A");
        test.put("fsd2", "B");
        test.put("h23", "AB");
        test.put("2134", "ABC");
        test.put("dsf2", "CD");
        if(!test.containsKey("as234s")){

            test.put("as234s", "B");
        }

        int A_count = 0;
        for (String i : test.keySet()) {
            if(test.get(i) == "A"){
                A_count++;
            }
            hset.add(test.get(i));
            //System.out.println(test.get(i));



            //System.out.println("Name: " + i + " Age: " + test.size());
        }

        //System.out.println(hset);
        //System.out.println(A_count);

    }
}
