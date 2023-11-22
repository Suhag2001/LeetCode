package src.com.leetcode.java.recursionANDbacktracking;

import java.util.Arrays;
//698. Partition to K Equal Sum Subsets
public class CanPartitionKSubset698 {

        public static boolean dfs(int[] nums, boolean[] visited, int k, int targetSum, int currSum, int index) {
            if (k == 0) return true;
            if (targetSum == currSum)
                return dfs(nums, visited, k - 1, targetSum, 0, nums.length - 1);
            for (int i = index; i >= 0; i--) {
                if (visited[i]) continue;
                if (i + 1 < nums.length && nums[i] == nums[i + 1] && !visited[i + 1]) continue;
                if (currSum + nums[i] > targetSum) continue;
                visited[i] = true;
                if (dfs(nums, visited, k, targetSum, currSum + nums[i], i - 1)) return true;
                visited[i] = false;
            }
            return false;
        }
        public static boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % k != 0) return false;
            int targetSum = sum / k;
            Arrays.sort(nums);
            return dfs(nums, new boolean[nums.length], k, targetSum, 0, nums.length - 1);
        }

    public static void main(String[] args) {
         int[] nums = {4,3,2,3,5,2,1};

        System.out.println( canPartitionKSubsets(nums, 4));

    }

}
