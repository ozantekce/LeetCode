package Push_Dominoes_838;

public class Solution {


    public static void main(String[] args) {

        System.out.println(pushDominoes(".L.R...LR..L.."));

    }

    public static String pushDominoes(String dominoes) {

        char values[] = dominoes.toCharArray();
        boolean used [] = new boolean[dominoes.length()];

        MyQueue queue = new MyQueue(dominoes.length());

        int n = values.length-1;

        for (int i = 0; i < values.length; i++) {
            if(values[i]!='.'){
                queue.add(i);
            }
        }
        char L = 'L';
        char R = 'R';
        char dot = '.';
        while (!queue.empty()){

            int current = queue.poll();
            used[current] = true;
            if(values[current]==L){
                int l = current-1;
                if(l>=0 && !used[l]){
                    if(values[l]==dot){
                        values[l] = L;
                        if(!used[l])
                            queue.add(l);
                    }else if(values[l]==R){
                        values[l] = dot;
                        used[l] = true;
                    }
                }
            }else{
                int r = current+1;
                if(r<=n && !used[r] && values[r]==dot){
                    values[r] = R;
                    queue.add(r);
                }
            }

        }
        return new String(values);
    }


    private static class MyQueue{

        int index = 0;
        int head = 0;
        int counter = 0;
        final int size;

        int data[];

        public MyQueue(int size) {
            this.size = size;
            data = new int[size];
        }

        public void add(int val){
            data[index]=val;
            index++;
            counter++;
        }

        public int poll(){
            int value = data[head];
            head++;
            counter--;
            return value;
        }

        public boolean empty(){ return counter==0; }


    }


}
