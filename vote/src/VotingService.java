/**Stephen Lee*/

import java.util.*;

public class VotingService {
    public Question q;
    public HashMap<String, String> id_answer_hashmap = new HashMap<String, String>();
    HashSet<String> answer_hashset = new HashSet<String>();

    /**VotingService Constructor */
    public VotingService(Question q){
        this.q = q;
    }

    /**Add a new student to VotingService via hashmap and hashset */
    public void addStudentAnswer(Student student){
        if(!id_answer_hashmap.containsKey(student.getId())){
            this.id_answer_hashmap.put(student.getId(), student.getAnswer());
            this.answer_hashset.add(student.getAnswer());
        }
    }

    /**Analyze all student answers and print the stats. */
    public void printStatistics(){
        List<String> list = new ArrayList<String>(answer_hashset);
        Collections.sort(list);
        ArrayList<Integer> counter = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (String j : id_answer_hashmap.keySet()) {
                if(id_answer_hashmap.get(j).equals(list.get(i))){
                    count++;
                }
            }
            counter.add(count);
        }

        /** Optional Code used to print the sorted list of possible answer choices and amount chosen */
        /*System.out.println(list);
        System.out.println(counter);*/

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" : ");
            sb.append(counter.get(i));
            sb.append(", ");
        }

        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb.toString());

        StringBuilder sb_correct_answer = new StringBuilder();
        for (int i = 0; i < q.correct_answer.length; i++) {
            sb_correct_answer.append(q.correct_answer[i]);
        }

        System.out.println("Correct answer is " + sb_correct_answer.toString() + ".");
    }

}
