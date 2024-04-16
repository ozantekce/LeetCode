package Number_of_Laser_Beams_in_a_Bank_2125;
public class Solution {


    public static void main(String[] args) {

        System.out.println(numberOfBeams(new String[]{"011001","000000","010100","001000"}));
        System.out.println(numberOfBeams(new String[]{"000","111","000"}));
        System.out.println(numberOfBeams(new String[]{"000"}));

    }


    public static int numberOfBeams(String[] bank) {

        char prev = 0;
        int res = 0;
        for (String str : bank) {
            char count = 0;
            byte[] bytes = str.getBytes();
            for (int j = 0; j < bytes.length; j++) {
                count += bytes[j];
            }
            count -= '0' * str.length();
            if (count != 0) {
                res += count * prev;
                prev = count;
            }
        }

        return res;
    }


}
