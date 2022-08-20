package Maximum_Binary_Tree_654;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        int [] nums =  {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (true){

            if(nodes.isEmpty()){
                break;
            }
            TreeNode currentNode = nodes.poll();
            if(currentNode!=null)
                System.out.println(currentNode.val);
            else{
                System.out.println("null");
                continue;
            }

            nodes.add(currentNode.left);
            nodes.add(currentNode.right);
        }

    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return recursive(0,nums.length-1,nums);
    }

    public static TreeNode recursive(int f,int l,int[] nums){

        if(f>l)
            return null;

        int maxIndex = maxIndex(f,l,nums);

        TreeNode currentNode
                = new TreeNode(
                        nums[maxIndex],
                        recursive(f,maxIndex-1,nums),
                        recursive(maxIndex+1,l,nums)
                );


        return currentNode;

    }


    public static int maxIndex(int f,int l,int nums []){
        int max = nums[f];
        int index = f;
        for (int i = f+1; i <= l; i++) {
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }

        }
        return index;
    }


    public static class TreeNode {
        int val;
        Maximum_Binary_Tree_654.Solution.TreeNode left;
        Maximum_Binary_Tree_654.Solution.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Maximum_Binary_Tree_654.Solution.TreeNode left, Maximum_Binary_Tree_654.Solution.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
