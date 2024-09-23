package Extra_Characters_in_a_String_2707;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {

        System.out.println(minExtraChar("dwmodizxvvbosxxw",  new String[]{
                "ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"
        }));

        System.out.println(minExtraChar("tpqojlnhenbzmqkqnxohmzakm",  new String[]{
                "enbzm","yy","xqnjw","cxwgv","q","ras","ezc","nt","eq","j","chfw",
                "v","ebh","tvwk","we","xhk","bumlw","czgy","njrml","pl","cxg","ztg",
                "mnvi","k","hslr","fwhrj","h","yqro","vpxyf","bps","nhuv","w","m","ln",
                "nxoh","skiun","qnqc","wtrwp","hl","ydbv","cv","a","tpqoj","umrj","nq","xadnx","emwv","dmuuw"
        }));

        System.out.println(minExtraChar("octncmdbgnxapjoqlofuzypthlytkmchayflwky", new String[]{
                "m","its","imaby","pa","ijmnvj","k","mhka",
                "n","y","nc","wq","p","mjqqa","ht","dfoa",
                "yqa","kk","pixq","ixsdln","rh","dwl",
                "dbgnxa","kmpfz","nhxjm","wg","wky",
                "oct","og","uhin","zxb","qz","tpf",
                "hlrc","j","l","tew","xbn","a",
                "uzypt","uvln","mchay","onnbi","hlytk",
                "pjoqlo","dxsjr","u","uj"
        }));

    }


    public static int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();

        for (String word : dictionary) {
            trie.add(word);
        }

        return trie.solve(s);
    }

    public static class Trie {

        private final Node root;
        private int [] memory;

        public Trie() {
            root = new Node();
        }

        public void add(String s) {
            Node current = root;
            for (char c : s.toCharArray()) {
                if (!current.hasChild(c)) {
                    current.addChild(c);
                }
                current = current.getChild(c);
            }
            current.last = true;
        }

        public int solve(String s) {
            char[] chars = s.toCharArray();
            memory = new int[chars.length];
            Arrays.fill(memory, -1);

            return solveRecursive(chars, 0);
        }



        public int solveRecursive(char[] chars, int i){

            if(memory[i] != -1)
                return memory[i];

            int started = i;

            int counter = 0;
            Node current = root;
            int currentWordLength = 0;
            int badCasePoint = 0;

            int min = Integer.MAX_VALUE;

            for (; i < chars.length; i++) {
                char c = chars[i];

                // return to root
                if(current != root && root.hasChild(c)){
                    min = Math.min(min,
                            counter + currentWordLength - badCasePoint + solveRecursive(chars,i));
                }

                if (current.hasChild(c)) {
                    current = current.getChild(c);
                    currentWordLength++;
                    if(current.last){
                        badCasePoint = currentWordLength;
                    }
                } else {
                    counter += currentWordLength - badCasePoint;
                    current = root;
                    currentWordLength = 0;
                    badCasePoint = 0;

                    if (root.hasChild(c)) {
                        current = root.getChild(c);
                        currentWordLength = 1;
                        if(current.last){
                            badCasePoint = currentWordLength;
                        }
                    } else {
                        counter++;
                    }
                }
            }

            counter += currentWordLength - badCasePoint;


            return memory[started] = Math.min(counter, min);
        }

        private static class Node {

            private Node[] children = new Node[26];
            private boolean last;

            public void addChild(char c) {
                children[c - 'a'] = new Node();
            }

            public Node getChild(char c) {
                return children[c - 'a'];
            }

            public boolean hasChild(char c) {
                return children[c - 'a'] != null;
            }

        }
    }
}
