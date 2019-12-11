package Assignment3;

import java.util.Scanner;

public class Assignment3_C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int id, floors, balls;
        for (int i = 0; i < t; i++) {
            id = in.nextInt();
            balls = in.nextInt();
            floors = in.nextInt();

            System.out.println(id + " " + Solution(balls,floors));
        }
    }

    static public int Solution(int ball, int floor) {
        int[][] dp = new int[51][1001];
        for (int i = 0; i < 1001; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i < 51; i++) {
            dp[i][1] = 1;
        }
        int maxval = Integer.MAX_VALUE;
        int maxans = Integer.MAX_VALUE;
        for (int i = 2; i <= ball; i++) {
            for (int j = 2; j <= floor; j++) {
                for (int k = 1; k < j; k++) {
                    maxans = Math.max(dp[i - 1][k - 1], dp[i][j-k]);
                    maxval = Math.min(maxval, maxans);
                }
                dp[i][j] = maxval + 1;
                maxval = Integer.MAX_VALUE;
            }
        }
        return dp[ball][floor];
    }
}

