package src.com.leetcode.java.tree;

//108. Convert Sorted Array to Binary Search Tree
public class SortedArrayToBST108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return  helper(nums,0 ,nums.length-1);
    }
    public static TreeNode helper(int[] nums,int low , int high){
        if(low > high) return null;
        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left= helper(nums, low, mid-1);
        node.right =helper(nums,mid+1, high);
        return node;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        PrintTreeNode.printTreeInFormat(sortedArrayToBST(nums));
    }
}
