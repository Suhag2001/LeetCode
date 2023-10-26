package src.com.leetcode.java.heap;

import java.util.PriorityQueue;
import java.util.Queue;


// 215. Kth Largest Element in an Array

public class FindKthLargest215 {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0 ; i < k ; i++){
            minHeap.add(nums[i]);
        }
        for(int i = k ; i < nums.length ; i++){
            if(minHeap.peek() < nums[i]){
                minHeap.poll() ;
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,};
        System.out.println(  findKthLargest(nums, 5));

    }
}
