package Smallest_String_Starting_From_Leaf_988;

public class Solution {

    public static void main(String[] args) {

    }


    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, new StringBuilder()).toString();
    }

    public StringBuilder smallestFromLeaf(TreeNode root, StringBuilder current) {

        char c = (char) ('a' + root.val);
        current.append(c);
        if(root.left == null && root.right == null){
            return current.reverse();
        }

        if(root.left != null && root.right !=null){
            StringBuilder left = smallestFromLeaf(root.left,  new StringBuilder(current));
            StringBuilder right = smallestFromLeaf(root.right,  new StringBuilder(current));
            return  left.compareTo(right) < 0 ? left : right;
        }else if(root.left != null){
            return smallestFromLeaf(root.left,  new StringBuilder(current));
        }else{
            return smallestFromLeaf(root.right,  new StringBuilder(current));
        }

    }

    private static class TreeNode {
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
