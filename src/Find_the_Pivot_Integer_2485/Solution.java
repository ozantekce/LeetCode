package Find_the_Pivot_Integer_2485;

public class Solution {


    public static void main(String[] args) {

        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));

    }

    public static int pivotInteger(int n) {

        double x = Math.sqrt((Math.pow(n,2)+n)/2);

        return (x%1)==0 ? (int)x:-1;
    }

}
