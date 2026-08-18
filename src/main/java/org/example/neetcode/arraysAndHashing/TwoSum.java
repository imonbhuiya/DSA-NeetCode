package org.example.neetcode.arraysAndHashing;

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


    public static void main(String[] args) {

        int[] nums = {5, 2, 8, 3};
        int target = 11;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + ", " + result[1]);
    }
}