package Restore_IP_Addresses_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {





    public static void main(String[] args) {

        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));

    }



    public static List<String> restoreIpAddresses(String s) {
        chars = s.toCharArray();
        results.clear();
        findRecursive(1,new StringBuilder().append(chars[0]), getIntValue(0),0,false);
        return results;
    }

    private static final List<String> results = new ArrayList<>();
    private static char[] chars;

    private static void findRecursive(
            int index
            ,StringBuilder stringBuilder
            ,int currentValue
            ,int numberOfDots
            ,boolean dotAdded){

        if(index>=chars.length || currentValue>255) return;

        if(numberOfDots == 3){
            int sizeOfRemainderPart = chars.length - index;

            if(sizeOfRemainderPart<=0 || sizeOfRemainderPart>3) return;

            if(sizeOfRemainderPart==1){
                stringBuilder.append(chars[index]);
                results.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(stringBuilder.length()-1);

            }else{

                if(getIntValue(index)==0)return;

                int val = 0;
                for (int i = index; i < chars.length; i++) {
                    val += getIntValue(i);
                    val *= 10;
                }

                if(val<=2550){
                    for (int i = index; i <chars.length ; i++) stringBuilder.append(chars[i]);
                    results.add(stringBuilder.toString());
                    for (int i = index; i <chars.length ; i++) stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            }

            return;
        }

        //addDot
        if(!dotAdded){
            findRecursive(index,stringBuilder.append('.'),0,numberOfDots+1,true);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        //increaseVal
        if(!dotAdded && currentValue == 0)return;

        findRecursive(index+1,stringBuilder.append(chars[index])
                ,currentValue*10+ getIntValue(index),numberOfDots,false);

        stringBuilder.deleteCharAt(stringBuilder.length()-1);

    }




    private static int getIntValue(int index) { return chars[index] -'0';}


}
