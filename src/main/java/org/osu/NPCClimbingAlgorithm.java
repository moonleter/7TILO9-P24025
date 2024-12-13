package org.osu;

public class NPCClimbingAlgorithm {
    private static final int STEPS_PER_FLOOR = 5;

    public static long[] findPossibleWays(int targetFloor, int targetStep) {
        if (targetFloor < 0 || targetStep < 0 || targetStep > STEPS_PER_FLOOR) {
            return new long[5];
        }

        int totalSteps = targetFloor * STEPS_PER_FLOOR + targetStep;
        long[] dp = new long[totalSteps + 1];
        dp[0] = 1;

        for (int i = 1; i <= totalSteps; i++) {
            if (i >= 1) dp[i] += dp[i - 1];
            if (i >= 2) dp[i] += dp[i - 2];
            if (i >= 3) dp[i] += dp[i - 3];
            if (i % STEPS_PER_FLOOR == 0) dp[i] += dp[i - STEPS_PER_FLOOR];
        }

        long[] paths = new long[5];
        paths[0] = totalSteps; // Number of 1 steps taken
        paths[1] = totalSteps / 2; // Number of 2 steps taken
        paths[2] = totalSteps / 3; // Number of 3 steps taken
        paths[3] = totalSteps / 5; // Number of elevator usages
        paths[4] = dp[totalSteps];

        return paths;
    }
}