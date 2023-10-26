package src.com.leetcode.java.heap;

import java.util.PriorityQueue;

//295. Find Median from Data Stream

public class MedianFinder295 {
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    static {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public static void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    } // TC: O(log n)

    public static double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.peek() * 1.0;
    } // TC: O(1)

    public static void main(String[] args) {
        addNum(2);
        addNum(4);
        System.out.println(findMedian());
    }
}
