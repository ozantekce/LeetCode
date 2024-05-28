package Get_Equal_Substrings_Within_Budget_1208;

public class Solution {


    public static void main(String[] args) {

        System.out.println(equalSubstring("abcd","bcdf",3));
        System.out.println(equalSubstring("abcd","cdef",3));
        System.out.println(equalSubstring("abcd","acde",0));

    }


    public static int equalSubstring(String s, String t, int maxCost) {

        int [] prefSums = new int[s.length()];
        prefSums[0] = Math.abs(t.charAt(0) - s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            prefSums[i] = prefSums[i-1] + Math.abs(t.charAt(i) - s.charAt(i));
        }

        int left = 0;
        int right = t.length() - 1;
        UpperWhile:
        while (left <= right){

            int mid = (right + left) / 2;
            for (int j = 0; j < s.length() - mid; j++) {
                int cost = prefSums[j + mid] - (j > 0 ? prefSums[j-1] : 0);
                if(cost <= maxCost){
                    left = mid + 1;
                    continue UpperWhile;
                }
            }

            right = mid -1;

        }

        return left;
    }


    private static int calculateCost(int start, int end, int [] prefSums){
        return prefSums[end] - (start > 0 ? prefSums[start-1] : 0);
    }





}
