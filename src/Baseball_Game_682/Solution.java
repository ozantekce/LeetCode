package Baseball_Game_682;

public class Solution {


    public static void main(String[] args) {

        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));

    }

    public static int calPoints(String[] operations) {
        int[] records = new int[operations.length];
        int size = 0;

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("+")) {
                int prev0 = records[size - 1];
                int prev1 = records[size - 2];
                int newScore = prev0 + prev1;
                records[size] = newScore;
                size++;
            } else if (op.equals("D")) {
                int prev0 = records[size - 1];
                int newScore = prev0 * 2;
                records[size] = newScore;
                size++;
            } else if (op.equals("C")) {
                size--;
            } else {
                int val = Integer.parseInt(op);
                records[size] = val;
                size++;
            }
        }

        int res = 0;
        for (int j = 0; j < size; j++) {
            res += records[j];
        }

        return res;
    }




}
