package src.com.leetcode.java.recursionANDbacktracking;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
public class GenerateParenthesis22 {
        public static List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            dfs(list, n, "",0,0);
            return list ;
        }

        public static void dfs(List<String> list, int max , String str , int open , int close ){
            if(2*max == str.length()){
                list.add(str);
            }
            if(open < max){
                dfs(list, max , str+"(", open+1, close);
            }
            if(close < open){
                dfs(list , max , str+")" , open , close+1);
            }
        }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(10));
    }

} //TC : O(4^n) and SC : O(n)
