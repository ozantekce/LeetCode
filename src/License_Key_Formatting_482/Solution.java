package License_Key_Formatting_482;

import java.util.Arrays;


public class Solution {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(licenseKeyFormatting("aaaa", 2));
    }
    
    public static String licenseKeyFormatting(String s, int k) {
        
        int letterCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '-') letterCount++;
        }
        
        if(letterCount <= 0) return "";
        
        int parts = letterCount / k;
        int remaining = letterCount - parts * k;
        int dashCount = parts - 1;
        if(remaining > 0) dashCount++;
        
        int length = dashCount + letterCount;
        int write = length - 1;

        char[] result = new char[length];
        int l = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '-') continue;

            if(l == k){
                result[write--] = '-';
                l = 0;
            }

            if(c >= 'a' && c <= 'z')c -= 32;
            result[write--] = c;
            l++;
        }
       
        return new String(result);
    }
    
}
