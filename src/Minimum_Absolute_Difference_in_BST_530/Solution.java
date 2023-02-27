package Minimum_Absolute_Difference_in_BST_530;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        node.right = new TreeNode(6);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(node));

        node = new TreeNode(41);
        node.left = new TreeNode(0);
        node.right = new TreeNode(48);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(49);

        System.out.println(getMinimumDifference(node));

        node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);

        System.out.println(getMinimumDifference(node));

        node = new TreeNode(543);
        node.left = new TreeNode(384);
        node.left.right = new TreeNode(445);
        node.right = new TreeNode(652);
        node.right.right = new TreeNode(699);
        System.out.println(getMinimumDifference(node));


    }

    private static List<Integer> list;
    public static int getMinimumDifference(TreeNode root) {
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
