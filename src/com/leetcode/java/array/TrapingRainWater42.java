package src.com.leetcode.java.array;

public class TrapingRainWater42 {

        public static int trap(int[] h) {
            int l = 0, r = h.length - 1, lmax = 0, rmax = 0, ans = 0;

            while (l < r) {
                lmax = Math.max(lmax, h[l]);
                rmax = Math.max(rmax, h[r]);

                if (lmax < rmax) {
                    ans += lmax - h[l];
                    l++;
                } else {
                    ans += rmax - h[r];
                    r--;
                }
            }

            return ans;
        }

    public static void main(String[] args) {
        int arr[]={1, 2, 0, 4, 0, 6};

        System.out.println(trap(arr));
    }
    }//TC : O(n) and SC : O(1)


