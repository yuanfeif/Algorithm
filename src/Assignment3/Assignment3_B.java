package Assignment3;

import java.util.Scanner;

public class Assignment3_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String a,b;
            a = in.next();
            b = in.next();
            System.out.println(Solution(a,b));
        }

    }

    static public int Solution(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for(int i = 1 ; i < s1.length + 1 ; i ++){
            for(int j = 1 ; j < s2.length + 1 ; j ++){
                if(s1[i - 1] == s2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}

