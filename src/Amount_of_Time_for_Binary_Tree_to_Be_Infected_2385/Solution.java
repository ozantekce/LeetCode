package Amount_of_Time_for_Binary_Tree_to_Be_Infected_2385;

import java.util.*;

public class Solution {


    public static void main(String[] args) {



    }

    private static MyNode newRoot;
    public static int amountOfTime(TreeNode root, int start) {

        newRoot = null;
        convert(null, root, start);

        Queue<MyNode> frontier = new ArrayDeque<>();
        HashSet<MyNode> visited = new HashSet<>();
        frontier.add(newRoot);
        int res = 0;
        while (!frontier.isEmpty()){

            MyNode current = frontier.poll();
            if(visited.contains(current))
                continue;
            System.out.println(current.val+" "+ current.min);
            res = Math.max(res, current.min);

            visited.add(current);

            MyNode p = current.Parent;
            MyNode l = current.Left;
            MyNode r = current.Right;

            if(p != null){
                frontier.add(p);
                p.min = current.min + 1;
            }
            if(l != null){
                frontier.add(l);
                l.min = current.min + 1;
            }
            if(r != null){
                frontier.add(r);
                r.min = current.min + 1;
            }

        }

        return res;
    }


    public static MyNode convert(MyNode parent, TreeNode current, int start){

        if(current == null){
            return null;
        }

        MyNode self = new MyNode();
        self.Parent = parent;
        self.val = current.val;

        self.Left = convert(self, current.left, start);
        self.Right = convert(self, current.right, start);

        if(self.val == start){
            newRoot = self;
        }

        return self;

    }


    private static class MyNode{
        int min;
        int val;
        MyNode Parent;
        MyNode Left;
        MyNode Right;
        public MyNode() {

        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
