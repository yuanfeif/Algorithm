package Assignment3;

import java.util.Scanner;

public class Assignment3_A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();
        int[] num = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = in.nextInt();
        }
        System.out.println(upSequent(num));

    }

    public static int upSequent(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

