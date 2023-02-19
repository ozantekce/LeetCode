package Sender_With_Largest_Word_Count_2284;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String [] messages = {"How is leetcode for everyone","Leetcode is useful for practice"};
        String [] senders = {"Bob","Charlie"};
        System.out.println(largestWordCount(messages,senders));
    }

    public static String largestWordCount(String[] messages, String[] senders) {

        HashMap<String,Integer> counter = new HashMap<>();
        int maxCount=0;
        String maxSender="";
        for (int i = 0; i < messages.length; i++) {

            int c = counter.getOrDefault(senders[i],0);
            c+=wordCount(messages[i]);
            counter.put(senders[i],c);
            if(maxCount<c){
                maxCount = c;
                maxSender = senders[i];
            }else if(maxCount==c && maxSender.compareTo(senders[i])<0){
                maxSender = senders[i];
            }

        }

        //System.out.println(counter);
        return maxSender;
    }


    public static int wordCount(String message){
        
        char [] chars = message.toCharArray();
        int c = 1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==32){
                c++;
            }
        }
        
        return c;
    }


}
