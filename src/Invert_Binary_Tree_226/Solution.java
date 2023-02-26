package Invert_Binary_Tree_226;

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

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(invertTree(root));

        System.out.println(root.left.val);
        System.out.println(root.right.val);



    }

    public static TreeNode invertTree(TreeNode root) {

        if(root==null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left==null && right ==null)
            return root;
        root.right = left;
        root.left = right;
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }

        return root;
    }


}
