package Count_of_Matches_in_Tournament_1688;

public class Solution {


    public static void main(String[] args) {

        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));

    }


    public static int numberOfMatches(int n) {

        int res = 0;
        while (n > 1){
            if(n % 2 == 0) {
                res += n/2;
                n = n/2;
            }else {
                res += (n-1)/2;
                n = (n - 1) / 2 + 1;
            }
        }
        return res;
    }

}
