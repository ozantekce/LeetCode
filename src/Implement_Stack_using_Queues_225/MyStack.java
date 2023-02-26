package Implement_Stack_using_Queues_225;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {


    private Queue<Integer> q0;
    private Queue<Integer> q1;

    public MyStack() {
        q0 = new ArrayDeque<>();
        q1 = new ArrayDeque<>();
    }

    public void push(int x) {

        q0.add(x);

    }

    public int pop() {
        int rst = 0;
        if(q0.isEmpty())
            return -1;
        while (q0.size()>1){
            q1.add(q0.poll());
        }
        rst = q0.poll();
        while (!q1.isEmpty()){
            q0.add(q1.poll());
        }
        return rst;
    }

    public int top() {
        int rst = 0;
        if(q0.isEmpty())
            return -1;
        while (q0.size()>1){
            q1.add(q0.poll());
        }
        rst = q0.poll();
        while (!q1.isEmpty()){
            q0.add(q1.poll());
        }
        q0.add(rst);
        return rst;
    }

    public boolean empty() {
        return q0.isEmpty();
    }
}
