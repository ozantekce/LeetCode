package Deepest_Leaves_Sum_1302;

public class Solution {


    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum(root));

    }


    public static int deepestLeavesSum(TreeNode root) {

        MaxDepthSum = 0;
        MaxDepth = 0;
        traveller(root,0);

        return MaxDepthSum;
    }


    private static int MaxDepth = 0;
    private static int MaxDepthSum = 0;

    public static void traveller(TreeNode treeNode,int depth){

        if(treeNode==null)
            return;
        //System.out.println("depth : "+depth+" val : "+ treeNode.val);
        if(depth>MaxDepth){
            MaxDepth = depth;
            MaxDepthSum = treeNode.val;
        }else if(depth==MaxDepth){
            MaxDepthSum+=treeNode.val;
        }

        traveller(treeNode.left,depth+1);

        traveller(treeNode.right,depth+1);


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
