package Count_Nodes_Equal_to_Average_of_Subtree_2265;

public class Solution {

    public static void main(String[] args) {


    }


    public int averageOfSubtree(TreeNode root) {
        Result = 0;
        recursive(root,0,0);
        return Result;
    }

    private static int Result;

    private static int[] recursive(TreeNode root, int sum, int count){

        if(root == null){
            return new int[]{0, 0};
        }
        if(root.left == null && root.right == null){
            Result++;
            return new int[]{root.val, 1};
        }

        int [] left  = recursive(root.left, sum, count);
        int [] right = recursive(root.right, sum, count);

        int [] sums = new int[2];
        sums[0] = left[0] + right[0] + root.val;
        sums[1] = left[1] + right[1] + 1;

        if(sums[0] / sums[1] == root.val){
            Result++;
        }

        return sums;
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
