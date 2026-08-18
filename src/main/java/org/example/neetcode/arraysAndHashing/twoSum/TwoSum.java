package org.example.neetcode.arraysAndHashing.twoSum;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int needed = target - current;

            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed), i};
            }

            seen.put(current, i);
        }

        return new int[]{};
    }

}