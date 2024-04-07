package String_Compression_443;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(compress(new char[]{'a','a','b','b','c','c','c','d','d','e'}));
        //System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

    }


    public static int compress(char[] chars) {

        int writeIndex = 0;
        int startIndex = 0;
        char lastChar = chars[0];
        char currentChar;

        for (int i = 1; i < chars.length; i++) {
            currentChar = chars[i];
            if(lastChar != currentChar){
                writeIndex = updateNums(i,startIndex,writeIndex,lastChar,chars);
                startIndex = i;
            }
            lastChar = currentChar;
        }
        writeIndex = updateNums(chars.length, startIndex,writeIndex,lastChar,chars);
        return writeIndex;
    }


    private static int updateNums(int i,int startIndex ,int writeIndex,char lastChar, char [] chars){

        int count = i - startIndex;
        if(count == 1){
            chars[writeIndex] = lastChar;
            return  writeIndex + 1;
        }

        int size = 1;
        if(count >= 1000) size = 4;
        else if(count >= 100) size = 3;
        else if(count >= 10) size = 2;

        //System.out.println(lastChar +" "+ size+" "+count);
        int increaseWriteIndex = 1;
        chars[writeIndex] = lastChar;
        if(count > 1){
            while (count > 0){
                int n = count % 10;
                count /= 10;
                chars[writeIndex + size--] = (char) ('0' + n);
                increaseWriteIndex++;
            }
        }
        writeIndex += increaseWriteIndex;
        //System.out.println(Arrays.toString(chars));
        return writeIndex;
    }


}
