package Length_of_Longest_Fibonacci_Subsequence_873;
import java.util.HashSet;


public class Solution {


    public static void main(String[] args) {


        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));

    }




    private static final HashSet<Integer> Set = new HashSet<>();
    public static int lenLongestFibSubseq(int[] arr) {
        Set.clear();
        for (int i = 0; i < arr.length; i++) {
            Set.add(arr[i]);
        }
        int maxCount = 0;
        for (int i = 0; i < arr.length-2; i++) {

            for (int j = i+1; j < arr.length-1; j++) {
                int first = arr[i];
                int second = arr[j];
                int third = first + second;
                if(Set.contains(third)){
                    int count = 3;
                    int last0 = second;
                    int last1 = third;
                    while (true){
                        int next = last0 + last1;
                        if(Set.contains(next)){
                            count++;
                            last0 = last1;
                            last1 = next;
                        }else{
                            break;
                        }
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }
        }


        return maxCount;
    }


}
