# Two Sum

## Problem

Given an integer array `nums` and an integer `target`, find two different elements whose sum equals the target.

Return the indices of those two elements.

### Example

Input:

nums = [2, 7, 11, 15]
target = 9

Output:

[0, 1]

Because:

2 + 7 = 9


## Pattern

HashMap — Complement Lookup


## Main Idea

For every number, calculate the number we need:

needed = target - current

Then check whether `needed` has already been seen.

The HashMap stores:

number → index


## Algorithm

1. Create an empty HashMap.
2. Iterate through the array.
3. Get the current number.
4. Calculate:

   needed = target - current

5. Check whether `needed` exists in the HashMap.
6. If it exists, return:
    - the stored index of `needed`
    - the current index
7. Otherwise, store:

   current number → current index

8. Continue through the array.


## Example Walkthrough

nums = [5, 2, 8, 3]
target = 11

| Current | Needed | HashMap Before | Action |
|---:|---:|---|---|
| 5 | 6 | {} | Store 5 → 0 |
| 2 | 9 | {5→0} | Store 2 → 1 |
| 8 | 3 | {5→0, 2→1} | Store 8 → 2 |
| 3 | 8 | {5→0, 2→1, 8→2} | Found 8 |

Result:

[2, 3]


## Complexity

**Time Complexity:** O(n)

We traverse the array once, and HashMap lookup is O(1) on average.

**Space Complexity:** O(n)

In the worst case, we may store up to n elements in the HashMap.


## What I Learned

- Complement lookup pattern
- Using a HashMap for fast lookup
- Storing `number → index`
- Difference between array values and indices
- Why we check for the complement before storing the current element


## Key Reminder

> Calculate needed → check HashMap → found: return indices → not found: store current number and index.


## Status

- [x] Pattern understood
- [x] Algorithm understood
- [ ] Solved independently on NeetCode
- [ ] Submitted successfully
- [ ] Re-solved without help