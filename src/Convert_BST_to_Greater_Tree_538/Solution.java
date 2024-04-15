package Convert_BST_to_Greater_Tree_538;

public class Solution {


    public static void main(String[] args) {

    }

    public static TreeNode convertBST(TreeNode root) {
        if(root != null)
            collectValues(root, 0);
        return root;
    }

    private static int collectValues(TreeNode root, int increase){

        root.val += increase;

        if(root.right != null){
            root.val += collectValues(root.right, increase) - increase;
        }

        if(root.left != null){
            return collectValues(root.left, root.val);
        }

        return root.val;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
