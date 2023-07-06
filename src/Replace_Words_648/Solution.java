package Replace_Words_648;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        long start = System.nanoTime();

        List<String> list;
        String sentence;

        list = new ArrayList<>(List.of("cat","bat","rat"));
        sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(list,sentence));

        list = new ArrayList<>(List.of("a","b","c"));
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(list,sentence));

        list = new ArrayList<>(List.of("a", "aa", "aaa", "aaaa"));
        sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(replaceWords(list,sentence));

        long end = System.nanoTime();

        System.out.println("Time taken: " + ((end - start)/1000000d) + " ms");
    }



    public static String replaceWords(List<String> dictionary, String sentence) {

        Trie trie = new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            trie.addWord(dictionary.get(i));
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            String root = trie.convert(words[i]);
            result.append(root);
            if(i!=words.length-1)
                result.append(" ");
        }


        return result.toString();
    }

    private static class Trie{

        private Node root = new Node();

        public void addWord(String word){
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                current = current.addOrGetChild(c);
            }
            current.isLast = true;
        }
        private static final StringBuilder result = new StringBuilder();
        public String convert(String word){
            result.setLength(0);
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                current = current.getChild(c);
                if(current!=null){
                    result.append(c);
                }else{
                    return word;
                }
                if(current.isLast) return result.toString();
            }
            return word;
        }

        private static class Node{

            private Node[] childs = new Node[26];
            private boolean isLast = false;

            public Node getChild(char c){
                return childs[c-'a'];
            }

            public Node addOrGetChild(char c){
                int i = c -'a';
                if(childs[i]==null)childs[i] = new Node();
                return childs[i];
            }

        }

    }

}
