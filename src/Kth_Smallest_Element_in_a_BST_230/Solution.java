package Kth_Smallest_Element_in_a_BST_230;

public class Solution {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(kthSmallest(root,4));

    }

    public static int kthSmallest(TreeNode root, int k) {

        int val = 0;
        for (int i = 0; i < k; i++) {
            val = removeLeftMost(null,root);
        }

        return val;
    }

    public static int removeLeftMost(TreeNode parent,TreeNode current){

        if(current.left==null){
            //left most
            int leftMostVal = current.val;
            if(current.right!=null){
                if(parent!=null)
                    parent.left = current.right;
                else{
                    current.val = current.right.val;
                    current.left = current.right.left;
                    current.right = current.right.right;
                }
            }else{
                if(parent!=null)
                    parent.left = null;
            }
            return leftMostVal;
        }else{
            return removeLeftMost(current,current.left);
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
