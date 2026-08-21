# Contains Duplicate

**Topic:** Arrays & Hashing  
**Difficulty:** Easy  
**Pattern:** HashSet / Seen Values  
**Status:** ✅ Accepted — 34/34 Test Cases

## Problem
Given an integer array `nums`, return `true` if any value appears more than once. Return `false` if every element is unique.

### Example 1
```text
Input: nums = [1, 2, 3, 1]
Output: true
Explanation: 1 appears more than once.
```

### Example 2
```text
Input: nums = [1, 2, 3, 4]
Output: false
Explanation: Every number appears only once.
```

### Example 3
```text
Input: nums = [5, 5, 5, 2, 3]
Output: true
Explanation: 5 appears more than once.
```

## Pattern — HashSet / Seen Values

```text
Have I seen this number before?

YES → return true
NO  → add it to the HashSet

Loop finishes → return false
```

## Why HashSet?

We only need to know whether a number has already appeared. We do not need its index or frequency.

```text
Two Sum           → HashMap<number, index>
Valid Anagram     → HashMap<character, frequency>
Contains Duplicate → HashSet<seen values>
```

## Step-by-Step Walkthrough

```text
nums = [4, 7, 2, 7, 9]

seen = {}

4 → not seen → add → {4}
7 → not seen → add → {4, 7}
2 → not seen → add → {4, 7, 2}
7 → already seen → duplicate found → return true
```

## Pseudocode

```text
CREATE empty HashSet called seen

FOR each number in nums
    IF number is already in seen
        RETURN true

    ADD number to seen

RETURN false
```

## Java Solution

```java
import java.util.HashSet;

class Solution {
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
}
```

## Complexity

**Time:** `O(n)`  
We process the array once. `HashSet.contains()` and `HashSet.add()` are `O(1)` on average.

**Space:** `O(n)`  
In the worst case, every value is unique, so the HashSet may store all `n` values.

## Key Learnings

```java
HashSet<Integer> seen = new HashSet<>();

seen.contains(number); // CHECK
seen.add(number);      // ADD
```

Mental pattern:

```text
CHECK → ADD

Already exists? → duplicate
Doesn't exist?  → add and continue
```

### HashSet vs HashMap

```text
Need existence only? → HashSet
Need key → value?    → HashMap
```

## Interview Explanation

I use a HashSet to store the numbers I have already seen. For each number, I check whether it is already in the HashSet. If it is, I found a duplicate and return `true`. Otherwise, I add the number to the HashSet. If the loop finishes without finding a duplicate, I return `false`.

## Mental Reminder

```text
Current number
      ↓
seen.contains(number)?
    /       \
  YES        NO
   ↓          ↓
 true      add number
              ↓
           continue

Loop finishes → false
```
https://neetcode.io/problems/duplicate-integer
