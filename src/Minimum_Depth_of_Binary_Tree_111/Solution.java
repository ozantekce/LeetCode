package Minimum_Depth_of_Binary_Tree_111;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {
        /*
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
*/
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        System.out.println(minDepth(head));

    }


    public static int minDepth(TreeNode root) {

        if(root==null)
            return 0;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        TreeNode current;
        TreeNode rightest = null;
        if(root.right!=null){
            rightest = root.right;
        }else if(root.left!=null){
            rightest = root.left;
        }else{
            return 1;
        }

        int depth = 2;
        while (true){

            current = nodeQueue.poll();
            boolean leftNotNull = current.left!=null;
            boolean rightNotNull = current.right !=null;


            if(leftNotNull && rightNotNull){
                nodeQueue.add(current.left);
                nodeQueue.add(current.right);
            }
            else if(leftNotNull){
                nodeQueue.add(current.left);
            }else if(rightNotNull){
                nodeQueue.add(current.right);
            }else{
                break;
            }

            if(current==rightest){
                depth++;
                if(rightest.right!=null){
                    rightest = rightest.right;
                }else if(rightest.left!=null){
                    rightest = rightest.left;
                }
            }

        }

        return depth;
    }


/*
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return traveller(root,1);
    }


    public int traveller(TreeNode node,int depth){

        boolean leftNotNull = node.left!=null;
        boolean rightNotNull = node.right !=null;

        if(leftNotNull && rightNotNull){
            int l = traveller(node.left,depth+1);
            int r = traveller(node.right,depth+1);
            return Math.min(l,r);
        }
        else if(leftNotNull){
            return traveller(node.left,depth+1);
        }else if(rightNotNull){
            return traveller(node.right,depth+1);
        }else{
            return depth;
        }

    }
*/

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }


}
