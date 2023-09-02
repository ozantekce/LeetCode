package Cinema_Seat_Allocation_1386;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        System.out.println(maxNumberOfFamilies(3,new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
        System.out.println(maxNumberOfFamilies(2,new int[][]{{2,1},{1,8},{2,6}}));
        System.out.println(maxNumberOfFamilies(4,new int[][]{{4,3},{1,4},{4,6},{1,7}}));

    }


    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer,Integer> numbers = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0] - 1;
            int col = reservedSeat[1] - 1;
            numbers.put(row, setBinary(numbers.getOrDefault(row, 0), col));
        }

        int counter = 0;
        for (int number : numbers.values()) {
            boolean cnt = false;
            if(case0.contains(number)){
                counter++;
                cnt = true;
            }
            if(case1.contains(number)){
                counter++;
                cnt = true;
            }
            if(cnt) continue;
            if(case2.contains(number)){
                counter++;
            }

        }

        counter += 2 * (n - numbers.size());

        return counter;
    }

    public static int setBinary(int number,int index){
        number += 1<<index;
        return number;
    }

    private static final HashSet<Integer> case0 = new HashSet<>();
    private static final HashSet<Integer> case1 = new HashSet<>();
    private static final HashSet<Integer> case2 = new HashSet<>();
    static{
        for (int i = 0; i <= 1023; i++) {

            int [] binaryValues = new int[9];
            int value = i;
            value = value>>1;
            binaryValues[1] = value & 1;
            value = value>>1;
            binaryValues[2] = value & 1;
            value = value>>1;
            binaryValues[3] = value & 1;
            value = value>>1;
            binaryValues[4] = value & 1;
            value = value>>1;
            binaryValues[5] = value & 1;
            value = value>>1;
            binaryValues[6] = value & 1;
            value = value>>1;
            binaryValues[7] = value & 1;
            value = value>>1;
            binaryValues[8] = value & 1;

            if(binaryValues[1]==0 && binaryValues[2]==0
                    && binaryValues[3]==0&& binaryValues[4]==0){
                case0.add(i);
            }
            if(binaryValues[5]==0 && binaryValues[6]==0
                    && binaryValues[7]==0&& binaryValues[8]==0){
                case1.add(i);
            }
            if(binaryValues[3]==0 && binaryValues[4]==0
                    && binaryValues[5]==0&& binaryValues[6]==0){
                case2.add(i);
            }
        }

    }



}
