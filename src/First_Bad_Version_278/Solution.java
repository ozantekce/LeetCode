package First_Bad_Version_278;

public class Solution {


    public static void main(String[] args) {

        bad = 1702766719;
        System.out.println(firstBadVersion(2126753390));
        bad = 4;
        System.out.println(firstBadVersion(5));
        bad = 1;
        System.out.println(firstBadVersion(1));

    }


    public static int firstBadVersion(int n) {

        long f = 0;
        long l = n;
        int rst = n;
        while (f<l){
            long mid = (f+l)/2;
            if(isBadVersion((int) mid)){
                l=mid;
                rst = (int) l;
            }else{
                f=mid+1;
            }
        }

        return rst;
    }


    static int bad = 1702766719;
    static boolean isBadVersion(int version){
        return version>=bad;
    }


}
