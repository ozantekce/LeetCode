package Defanging_an_IP_Address_1108;

public class Solution {


    public String defangIPaddr(String address) {

        StringBuilder stringBuilder = new StringBuilder(address.length() + 6);

        for (int i = 0; i < address.length(); i++) {

            char c = address.charAt(i);
            if(c == '.'){
                stringBuilder.append('[');
                stringBuilder.append('.');
                stringBuilder.append(']');
            }else{
                stringBuilder.append(c);
            }

        }

        return stringBuilder.toString();
    }

}
