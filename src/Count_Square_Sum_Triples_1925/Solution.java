package Count_Square_Sum_Triples_1925;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(countTriples(5));
        System.out.println(countTriples(10));
        //System.out.println(countTriples(12));

    }


    public static int countTriples(int n) {

        int n2 = n*n;
        int r = 0;
        for (int i = 1; i <= n; i++) {
            int i2 = i*i;
            for (int j = 1; j <= n; j++) {
                int c = i2 + j*j;
                if(n2<c)continue;
                double cs = Math.sqrt(c);
                if(cs==((int)cs) && cs<=n){
                    r++;
                }
            }

        }

        return r;
    }


}
