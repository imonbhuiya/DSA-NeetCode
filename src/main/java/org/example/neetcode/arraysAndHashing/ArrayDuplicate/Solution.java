package org.example.neetcode.arraysAndHashing.ArrayDuplicate;

// Added missing import
import java.util.HashSet;

class Solution {
    // The method that checks for duplicates
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }

    // Added main method to execute and test the code
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Contains duplicates (returns true)
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1 Result: " + solution.hasDuplicate(test1));

        // Test Case 2: All unique values (returns false)
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2 Result: " + solution.hasDuplicate(test2));
    }
}
