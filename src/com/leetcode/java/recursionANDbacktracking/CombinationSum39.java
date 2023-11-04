package src.com.leetcode.java.recursionANDbacktracking;

import java.util.ArrayList;
import java.util.List;

//39. Combination Sum

public class CombinationSum39 {

        public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> comb, int target, int sum, int start) {
            if (sum == target) {
                list.add(new ArrayList<>(comb));
                return;
            } else if (sum > target) return;

            for (int i = start; i < nums.length; i++) {
                comb.add(nums[i]);
                dfs(nums, list, comb, target, sum + nums[i], i);
                comb.remove(comb.size() - 1);
            }
        }
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            dfs(candidates, list, new ArrayList<>(), target, 0, 0);
            return list;
        }

    public static void main(String[] args) {
        int[] candidate = {1,3,2,4,5,5,6};
        int target = 3;
        System.out.println(combinationSum(candidate, target));
    }
    } //TC : O(2^k * n ) and SC : O(k)

