package src.com.leetcode.java.recursionANDbacktracking;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
public class Combinations77 {

        public static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> list = new ArrayList<>();
            dfs(list, new ArrayList<>() , n, k ,1);
            return list;
        }

        public static void dfs(List<List<Integer>> list , List<Integer> comb , int n , int k , int start){
            if(comb.size()== k){
                list.add(new ArrayList<>(comb));
                return;
            }
            for(int i = start ; i<=n ; i++){
                comb.add(i);
                dfs(list,comb,n, k , i+1);
                comb.remove(comb.size()-1);
            }
        }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    }

