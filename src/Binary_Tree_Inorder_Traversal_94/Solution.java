package Binary_Tree_Inorder_Traversal_94;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<Integer>();
        iterative(list, root);
        return list;
    }


    private static void iterative(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
    }


    private static void recursive(List<Integer> list, TreeNode root){
        if(root == null)
            return;
        if(root.left != null){
            recursive(list, root.left);
        }
        list.add(root.val);
        if(root.right != null){
            recursive(list, root.right);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
