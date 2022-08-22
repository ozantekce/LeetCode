package Construct_String_from_Binary_Tree_606;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);

        System.out.println(tree2str(node));

    }


    public static String tree2str(TreeNode root) {

        str = new StringBuilder();
        recursive(root);
        return  str.toString();
    }


    static StringBuilder str;
    private static void recursive(TreeNode current){

        if(current==null)
            return ;
        str.append(current.val);

        if(current.left ==null && current.right ==null)
            return;

        str.append("(");
        recursive(current.left);
        str.append(")");

        if(current.right == null)
            return;

        str.append("(");
        recursive(current.right);
        str.append(")");



    }



    public static class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
