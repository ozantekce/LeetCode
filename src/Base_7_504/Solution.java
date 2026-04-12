package Base_7_504;

public class Solution {
    
    public static void main(String[] args) {
        
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }
    
    public static String convertToBase7(int num) {
        
        if(num == 0) return "0";
        
        boolean isNegative = num < 0;
        if(isNegative) num *= -1;
        StringBuilder stringBuilder = new StringBuilder();
        
        while (num > 0) {            
            int r = num % 7;
            stringBuilder.append(r);
            num = num / 7;
            System.out.println(num +" "+ r);
        }
        if(isNegative) stringBuilder.append('-');
        
        return stringBuilder.reverse().toString();
    }
}
