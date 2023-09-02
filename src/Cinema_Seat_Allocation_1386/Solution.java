package Cinema_Seat_Allocation_1386;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {


        System.out.println(maxNumberOfFamilies(3,new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
        System.out.println(maxNumberOfFamilies(2,new int[][]{{2,1},{1,8},{2,6}}));
        System.out.println(maxNumberOfFamilies(4,new int[][]{{4,3},{1,4},{4,6},{1,7}}));

    }


    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        configuration();

        sortArray(reservedSeats);
        int counter = 0;
        int number;
        int row = reservedSeats[0][0]-1;
        int col = reservedSeats[0][1]-1;
        int lastRow = row;
        int remainder = n;
        number = setBinary(0,col);

        for (int i = 1; i < reservedSeats.length; i++) {

            row = reservedSeats[i][0]-1;
            col = reservedSeats[i][1]-1;
            if(row != lastRow){
                remainder--;
                boolean cnt = false;
                if(case0.contains(number)){
                    counter++;
                    cnt = true;
                }
                if(case1.contains(number)){
                    counter++;
                    cnt = true;
                }
                if(!cnt && case2.contains(number)){
                    counter++;
                }
                number = 0;
            }
            lastRow = row;
            number = setBinary(number,col);

        }
        boolean cnt = false;
        remainder--;
        if(case0.contains(number)){
            counter++;
            cnt = true;
        }
        if(case1.contains(number)){
            counter++;
            cnt = true;
        }
        if(!cnt && case2.contains(number)){
            counter++;
        }

        if(remainder<0)remainder=0;
        return counter+ remainder*2;
    }

    public static void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
    }

    public static int setBinary(int number,int index){
        number += 1<<index;
        return number;
    }

    private static boolean configurated = false;
    private static HashSet<Integer> case0 = new HashSet<>();
    private static HashSet<Integer> case1 = new HashSet<>();
    private static HashSet<Integer> case2 = new HashSet<>();
    public static void configuration(){
        if(configurated) return;
        configurated = true;
        for (int i = 0; i <= 1023; i++) {

            StringBuilder binary = new StringBuilder(Integer.toBinaryString(i));

            while (binary.length() < 10) {
                binary.insert(0, "0");
            }

            if(checkBinaryCase0(binary)){
                case0.add(i);
            }
            if(checkBinaryCase1(binary)){
                case1.add(i);
            }
            if(checkBinaryCase3(binary)){
                case2.add(i);
            }
        }
        
    }

    public static boolean checkBinaryCase0(StringBuilder binary) {
        return binary.charAt(1) == '0' && binary.charAt(2) == '0' &&
                binary.charAt(3) == '0' && binary.charAt(4) == '0';
    }

    public static boolean checkBinaryCase1(StringBuilder binary) {
        return binary.charAt(5) == '0' && binary.charAt(6) == '0' &&
                binary.charAt(7) == '0' && binary.charAt(8) == '0';
    }

    public static boolean checkBinaryCase3(StringBuilder binary) {
        return binary.charAt(3) == '0' && binary.charAt(4) == '0' &&
                binary.charAt(5) == '0' && binary.charAt(6) == '0';
    }

}
