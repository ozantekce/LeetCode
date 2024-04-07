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

        for (int i = 1; i < chars.length+1; i++) {
            if(i < chars.length)
                currentChar = chars[i];
            else
                currentChar = ' ';

            if(lastChar != currentChar){
                int count = i - startIndex;
                int size = 0;
                int tempNum = count;
                while (tempNum > 0){
                    tempNum /= 10;
                    size++;
                }
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
                startIndex = i;
                //System.out.println(Arrays.toString(chars));
            }

            lastChar = currentChar;
        }


        return writeIndex;
    }

}
