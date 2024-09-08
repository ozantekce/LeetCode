package Sum_Root_to_Leaf_Numbers_129;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

    }

    public static int sumNumbers(TreeNode root) {

        Queue<TreeNode> frontier = new ArrayDeque<>();

        frontier.add(root);

        int sum = 0;

        while (!frontier.isEmpty()){

            TreeNode current = frontier.poll();
            if(isLeaf(current)){
                sum += current.val;
                continue;
            }

            TreeNode left = current.left;
            TreeNode right = current.right;

            if(left != null){
                left.val += current.val * 10;
                frontier.add(left);
            }

            if(right != null){
                right.val += current.val * 10;
                frontier.add(right);
            }
        }


        return sum;
    }

    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
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
