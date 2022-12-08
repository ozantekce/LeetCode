package Number_of_Students_Unable_to_Eat_Lunch_1700;

public class Solution {

    public static void main(String[] args) {

        int [] students = {1,1,1,0,0,1};
        int [] sandwiches  = {1,0,0,0,1,1};

        System.out.println(countStudents(students,sandwiches));

    }

    public static int countStudents(int[] students, int[] sandwiches) {
        
        int [] counterStudents = new int[2];
        for (int i = 0; i < students.length; i++) {
            counterStudents[students[i]]++;
        }

        int i;
        for (i = 0; i < sandwiches.length; i++) {

            if(counterStudents[sandwiches[i]]==0){
                break;
            }
            counterStudents[sandwiches[i]]--;
        }

        return sandwiches.length-i;
    }


}
