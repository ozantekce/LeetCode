package Design_Add_and_Search_Words_Data_Structure_211;

public class WordDictionary {

    /*
    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }
    */

    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }


    private static class Trie{

        private Node root;

        public Trie(){
            root = new Node();
        }


        public void add(String str){
            Node current = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                current = current.addOrGetChild(c);
            }
            current.isLast = true;
        }

        public boolean search(String str){
            return search(str, root, 0);
        }

        private boolean search(String str, Node node, int i){

            for (; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c != '.'){
                    node = node.getChild(c);
                    if(node == null){
                        return false;
                    }
                }else{
                    for (int j = 0; j < node.childs.length; j++) {
                        Node child = node.childs[j];
                        if(child != null){
                            boolean res = search(str, child, i+1);
                            if(res){
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }

            return node.isLast;
        }

        private static class Node{
            private Node[] childs;
            private boolean isLast = false;

            public Node(){
                childs = new Node[26];
            }

            public Node getChild(char c){
                return childs[c - 'a'];
            }

            public Node addOrGetChild(char c){
                int i = c - 'a';
                if(childs[i] == null){
                    childs[i] = new Node();
                }
                return childs[i];
            }


        }

    }


}
