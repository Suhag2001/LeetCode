package src.com.leetcode.java.recursionANDbacktracking;

import java.util.LinkedList;
import java.util.List;

//17. Letter Combinations of a Phone Number
public class LetterCombinations17 {
        public static List<String> letterCombinations(String digits) {
            LinkedList<String> list = new LinkedList<>();
            if (digits.length() == 0) return list;
            list.add("");
            String[] map =  { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            for (int i = 0; i < digits.length(); i++) { // "234"
                int index = Character.getNumericValue(digits.charAt(i));
                while (list.peek().length() == i) {
                    String tmp = list.remove();
                    for (char ch : map[index].toCharArray()) {
                        list.add(tmp + ch);
                    }
                }
            }
            return list;
        }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345655553"));
    }
    } // TC: O(4^n), SC: O(n)

