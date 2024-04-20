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


    private static void iterative(List<Integer> list, TreeNode root){

        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode current = stack.pop();

            if(current.right != null){
                stack.push(current.right);
            }

            if(current.left != null){
                stack.push(current);
                stack.push(current.left);
                current.left = null;
                current.right = null;
            }else{
                list.add(current.val);
            }

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
