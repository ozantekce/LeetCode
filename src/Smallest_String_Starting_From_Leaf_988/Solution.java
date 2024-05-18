package Smallest_String_Starting_From_Leaf_988;

public class Solution {

    public static void main(String[] args) {

    }


    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, new StringBuilder()).toString();
    }

    public String smallestFromLeaf(TreeNode root, StringBuilder current) {

        char c = (char) ('a' + root.val);
        current.append(c);
        if(root.left == null && root.right == null){
            StringBuilder res = new StringBuilder(current);
            return res.reverse().toString();
        }

        if(root.left != null && root.right !=null){
            String left = smallestFromLeaf(root.left,  current);
            current.setLength(current.length() - 1);
            String right = smallestFromLeaf(root.right,  current);
            current.setLength(current.length() - 1);
            return left.compareTo(right) < 0 ? left : right;
        }else if(root.left != null){
            String left = smallestFromLeaf(root.left,  current);
            current.setLength(current.length() - 1);
            return left;
        }else{
            String right = smallestFromLeaf(root.right,  current);
            current.setLength(current.length() - 1);
            return right;
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
