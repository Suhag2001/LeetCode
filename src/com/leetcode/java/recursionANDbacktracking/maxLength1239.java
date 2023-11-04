package src.com.leetcode.java.recursionANDbacktracking;

import java.util.ArrayList;
import java.util.List;

public class maxLength1239 {

        public static int maxLength(List<String> arr) {
            return dfs(arr, "", 0) ;
        }
        public static int dfs(List<String> arr, String str , int curr){
            if(curr==arr.size()){
                return str.length();
            }
            int left = 0 , right = 0 ;
            String temp = str+arr.get(curr);
            if(isUnique(temp)){
                left = dfs(arr, temp , curr+1);
            }
            right = dfs(arr, str, curr+ 1);
            return Math.max(left , right);
        }
        public static boolean isUnique(String temp){
            int[] arr = new int[26];
            for(int i = 0 ; i<temp.length(); i++){
                arr[temp.charAt(i)-'a']++;
            }
            for(int i = 0 ; i<arr.length ; i++){
                if(arr[i]>1) return false;
            }
            return true;
        }

    public static void main(String[] args) {
            List<String> arr = new ArrayList<String>();
            arr.add("char");
            arr.add("r");
            arr.add("act");
            arr.add("ers");
        System.out.println(maxLength(arr));
    }
    }// TC : O(n * 2^n) and SC : O(n)

