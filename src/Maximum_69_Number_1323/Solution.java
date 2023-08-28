package Maximum_69_Number_1323;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }


    public static int maximum69Number (int num) {

        int result = num;

        int i = 1;
        int recordI = -1;
        while (num>0){
            int c = num%10;
            num/=10;
            if(c==6){
                recordI = i;
            }
            i*=10;
        }

        if(recordI!=-1){
            result += 3*recordI;
        }

        return result;
    }

}
