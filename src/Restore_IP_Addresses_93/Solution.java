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
        result.clear();
        //counter = 0;
        findRecursive(1,new StringBuilder().append(s.charAt(0)),charToInt(s.charAt(0)),0,s.toCharArray(),false);
        //System.out.println(counter);
        return result;
    }

    private static List<String> result = new ArrayList<>();
    //private static int counter = 0;
    private static void findRecursive(int index, StringBuilder stringBuilder,int currentValue,int numberOfDots, char[] chars,boolean dotAdded){

        if(index>=chars.length || currentValue>255) return;

        if(numberOfDots == 3){
            int sizeOfRemainderPart = chars.length - index;
            if(sizeOfRemainderPart<=0) return;
            if(sizeOfRemainderPart==1){
                //counter++;
                StringBuilder s = new StringBuilder(stringBuilder.toString());
                for (int i = index; i <chars.length ; i++) {
                    s.append(chars[i]);
                }
                //System.out.println(s);
                result.add(s.toString());
            }else if(sizeOfRemainderPart<=3){
                if(charToInt(chars[index])==0)return;
                int val = 0;
                for (int i = index; i < chars.length; i++) {
                    val += charToInt(chars[i]);
                    val *= 10;
                }
                val/=10;
                if(val<=255){
                    //counter++;
                    StringBuilder s = new StringBuilder(stringBuilder.toString());
                    for (int i = index; i <chars.length ; i++) {
                        s.append(chars[i]);
                    }
                    //System.out.println(s);
                    result.add(s.toString());
                }
            }

            return;
        }

        //addDot
        if(!dotAdded){
            findRecursive(index,stringBuilder.append('.'),0,numberOfDots+1,chars,true);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        //increaseVal

        if(!dotAdded){
            if(currentValue==0)return;
        }

        findRecursive(index+1,stringBuilder.append(chars[index]),currentValue*10+charToInt(chars[index]),numberOfDots,chars,false);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

    }




    private static int charToInt(char c) { return c -'0';}



}
