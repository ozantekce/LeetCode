package Increasing_Order_Search_Tree_897;

public class Solution {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode current = increasingBST(root);
        while (true){
            if(current==null)
                break;
            System.out.println(current.val);
            current = current.right;

        }

    }

    public static TreeNode increasingBST(TreeNode root) {
        newRoot = null;
        currentNode = null;
        traveller(root);
        return newRoot;
    }
    static TreeNode newRoot;
    static TreeNode currentNode;
    public static void traveller(TreeNode treeNode){

        if(treeNode==null)
            return;
        traveller(treeNode.left);
        if(currentNode == null){
            newRoot = new TreeNode(treeNode.val);
            currentNode = newRoot;
        }else {
            currentNode.right = new TreeNode(treeNode.val);
            currentNode = currentNode.right;
        }
        traveller(treeNode.right);


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
