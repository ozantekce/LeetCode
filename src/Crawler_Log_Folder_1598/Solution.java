package Crawler_Log_Folder_1598;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

    }


    public static int minOperations(String[] logs) {

        int res = 0;
        for (String log : logs) {
            if (log.charAt(1) == '.') {
                if (res != 0)
                    res--;
            } else if (log.charAt(0) != '.') {
                res++;
            }
        }
        return res;
    }


}
