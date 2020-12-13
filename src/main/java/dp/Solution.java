package dp;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    // 使用最小的硬币数
    private int minCount;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        return dfs(coins, amount, 0, new HashMap<>());
    }


    private int dfs(int[] coins, int amount, int level, Map<Integer, Integer> cache) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (cache.get(amount) != null) {
            return cache.get(amount);
        }
        for (int i = 0; i < coins.length; i++) {
            if (cache.get(amount - coins[i]) == null) {
                int val = dfs(coins, amount - coins[i], level + 1, cache);
                val = (val == -1 ? -1 : val + 1);
                cache.put(amount, val);
            }
        }
        return cache.get(amount);
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,5,6,7,8,9};
        int i = new Solution().coinChange(ints, 25);
        System.out.println(i);
    }
}
