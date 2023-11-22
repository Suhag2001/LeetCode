package src.com.leetcode.java.array;

public class FirstandLastPosition34 {
        public static int[] searchRange(int[] nums, int target) {
            int[] ans = new int[2];
            ans[0] = findFirst(nums, target);
            ans[1] = findLast(nums, target);
            return ans;
        }

        public static int findFirst(int[] arr, int target) {
            int index = -1;
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] == target) {
                    index = mid;
                    high = mid - 1;
                } else if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return index;
        }

        public static int findLast(int[] arr, int target) {
            int index = -1;
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] == target) {
                    index = mid;
                    low = mid + 1;
                } else if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return index;
        }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(  searchRange(arr , 8));;
    }
    }//TC: O(log n) and SC : O(1)


