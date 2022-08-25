import java.lang.reflect.Array;
import java.util.Arrays;

public class Count_Integers_With_Even_Digit_Sum_2180 {


    public static void main(String[] args) {

        System.out.println("i : "+99+" val : "+countEven(99));


    }

    public static int countEven(int num) {

        int rtn = 0;
        for (int i = 1; i <= num; i++) {

            if(sumDigits(i)%2==0){
                rtn++;
            }

        }

        return rtn;
    }


    public static int sumDigits(int i) {
        return i == 0 ? 0 : i % 10 + sumDigits(i / 10);
    }
}
