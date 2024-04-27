package Design_HashMap_706;

public class Solution {


    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();
        map.remove(14);
        System.out.println(map.get(4));
        map.put(7,3);
        map.put(11,1);
        map.put(12,1);
        System.out.println(map.get(7));
        map.put(1,19);
        map.put(0,3);
        map.put(1,8);
        map.put(2,6);

    }

    private static class MyHashMap {

        Node root;
        public MyHashMap() {
            root = new Node();
        }

        public void put(int key, int value) {
            root.put(key, value);
        }

        public int get(int key) {
            return root.get(key);
        }

        public void remove(int key) {
            root.remove(key);
        }

        private static class Node{

            private final int range = 100;
            private int value = -1;
            private Node[] nodes;

            public Node(int value){
                this.value = value;
                nodes = new Node[range];
            }

            public Node(){
                nodes = new Node[range];
            }

            public int get(int key){
                if(key <= 0){
                    return value;
                }else{
                    int i = key % range;
                    key /= range;
                    if(nodes[i] != null){
                        return nodes[i].get(key);
                    }
                }
                return -1;
            }

            public void put(int key, int value){
                if(key <= 0){
                    this.value = value;
                }else{
                    int i = key % range;
                    key /= range;
                    if(nodes[i] == null){
                        if(key <= 0){
                            nodes[i] = new Node(value);
                        }else{
                            nodes[i] = new Node();
                            nodes[i].put(key, value);
                        }
                    }else{
                        nodes[i].put(key, value);
                    }
                }

            }

            public void remove(int key){
                if(key <= 0){
                    this.value = -1;
                }else{
                    int i = key % range;
                    key /= range;
                    if(nodes[i] != null){
                        nodes[i].remove(key);
                    }
                }
            }
        }

    }


}
