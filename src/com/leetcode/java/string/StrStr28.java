package src.com.leetcode.java.string;

public class StrStr28 {


        public static int strStr(String haystack, String needle) {
            if(haystack.contains(needle)){
                return haystack.indexOf(needle);
            }
            return -1;
        }

    public static void main(String[] args) {
        String a = "suhagmohinkar";
        String b = "hag";
        System.out.println(strStr(a,b));
    }
    }

