import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class VotingService {

    public Question q;
    public HashMap<String, String> id_answer_hashmap = new HashMap<String, String>();
    HashSet<String> answer_hashset = new HashSet<String>();

    public VotingService(Question q){
        this.q = q;
    }

    public void addStudentAnswer(Student student){
        if(!id_answer_hashmap.containsKey(student.getId())){
            this.id_answer_hashmap.put(student.getId(), student.getAnswer());
            this.answer_hashset.add(student.getAnswer());
        }
        /*if(question_type.equals("MC")){
            if (student.getAnswer().equals("A") || student.getAnswer().equals("B") || student.getAnswer().equals("C") || student.getAnswer().equals("D")){
                System.out.println("Acceptable answer");
            }

        }*/
    }

    public void printStatistics(){

        System.out.println(id_answer_hashmap);
        TreeSet<String> treeSet = new TreeSet<String>(answer_hashset);
        System.out.println(treeSet);
        //System.out.println("Correct answer is " + Arrays.toString(this.q.correct_answer));
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

        System.out.println(hset);
        TreeSet<String> treeSet = new TreeSet<String>(hset);
        System.out.println(treeSet);
        //System.out.println(A_count);

    }
}
