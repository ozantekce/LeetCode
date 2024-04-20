package Convert_Sorted_Array_to_Binary_Search_Tree_108;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
        System.out.println(sortedArrayToBST(new int[]{0,1,2,3,4,5}));

    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return recursive(0, nums.length-1, nums);
    }


    private static TreeNode recursive(int first, int last, int[] nums){

        int mid = (first + last) / 2;
        if(mid < first || mid > last){
            return null;
        }

        TreeNode root = new TreeNode(nums[mid]);

        root.left = recursive(first, mid - 1, nums);

        root.right = recursive(mid + 1,last , nums);

        return root;
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

      @Override
      public String toString() {
          return "TreeNode{" +
                  "val=" + val +
                  ", left=" + left +
                  ", right=" + right +
                  '}';
      }
  }

}
