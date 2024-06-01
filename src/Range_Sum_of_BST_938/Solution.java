package Range_Sum_of_BST_938;

public class Solution {


    public static void main(String[] args) {

    }


    public static int rangeSumBST(TreeNode root, int low, int high) {

        if(root == null)
            return 0;
        int val = root.val;
        int sum = val >= low && val <= high ? val : 0;

        if(val > low)
            sum += rangeSumBST(root.left, low, high);
        if(val < high)
            sum += rangeSumBST(root.right, low, high);


        return sum;
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
