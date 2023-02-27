package Minimum_Distance_Between_BST_Nodes_783;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    private static List<Integer> list;
    public static int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        recursive(root);
        int lastVal = list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,Math.abs(list.get(i)-lastVal));
            lastVal = list.get(i);
        }

        return min;
    }

    public static void recursive(TreeNode root){

        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null){
            recursive(left);
        }
        list.add(root.val);
        if(right!=null){
            recursive(right);
        }
    }

}
