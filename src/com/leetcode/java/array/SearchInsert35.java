package src.com.leetcode.java.array;

public class SearchInsert35 {

        public static int searchInsert(int[] nums, int target) {
            int left = 0 , right = nums.length-1 ;

            while(left<right){
                int mid = left + (right-left)/2 ;
                if(nums[mid]==target){
                    return mid ;
                }else if(nums[mid]<target){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            return (nums[left]<target)?left+1 :left;
        }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9};
        System.out.println(searchInsert(arr, 5));
    }

    } //TC : log(n) and SC : O(n)

