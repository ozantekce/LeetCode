package Crawler_Log_Folder_1598;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

    }


    public static int minOperations(String[] logs) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < logs.length; i++) {

            String log = logs[i];

            if(log.charAt(0) == '.'){
                if(log.charAt(1) == '.'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
            }else{
                stack.push(log);
            }

        }

        return stack.size();
    }


}
