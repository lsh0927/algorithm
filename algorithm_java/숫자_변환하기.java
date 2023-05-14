import java.util.*;

class Solution {
   public int solution(int x, int y, int n) {
    int[] dp = new int[y+1];
    Arrays.fill(dp, y+1);
    dp[x] = 0;

    for (int i = x; i < y; i++) {
        if (dp[i] == y+1) continue;
        if (i + n <= y) dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
        if (i * 2 <= y) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
        if (i * 3 <= y) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
    }

    return dp[y] == y+1 ? -1 : dp[y];
}

}