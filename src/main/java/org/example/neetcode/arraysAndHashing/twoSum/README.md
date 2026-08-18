**# 🧩 Two Sum

**Topic:** Arrays & Hashing  
**Difficulty:** Easy  
**Pattern:** HashMap — Complement Lookup

---

## 📌 Problem

Given an integer array `nums` and an integer `target`, return the indices of two numbers such that they add up to `target`.

Each input has exactly one solution, and the same element cannot be used twice.

---

## 🧪 Example

### Input

```java
int[] nums = {2, 7, 11, 15};
int target = 9;
```

### Output

```text
[0, 1]
```

### Explanation

```text
nums[0] + nums[1]
= 2 + 7
= 9
```

Therefore:

```text
[0, 1]
```

---

# 🧠 Pattern

## HashMap — Complement Lookup

The main formula is:

```java
needed = target - current;
```

For every number, I ask:

> What number do I need to reach the target?

Then I check whether that number has already been seen.

---

## 💡 Main Idea

The `HashMap` stores:

```text
number → index
```

Example:

```text
5 → 0
2 → 1
8 → 2
```

For every element:

```text
Calculate needed
       ↓
Check HashMap
       ↓
Is needed already there?
      /          \
    YES           NO
     ↓             ↓
Return          Store
indices       current → index
```

---

# 🔍 Example Walkthrough

Consider:

```java
int[] nums = {5, 2, 8, 3};
int target = 11;
```

### Iteration 1

```text
current = 5
index   = 0

needed = 11 - 5
       = 6
```

`6` is not in the HashMap.

Store:

```text
5 → 0
```

---

### Iteration 2

```text
current = 2
index   = 1

needed = 11 - 2
       = 9
```

`9` is not in the HashMap.

Store:

```text
5 → 0
2 → 1
```

---

### Iteration 3

```text
current = 8
index   = 2

needed = 11 - 8
       = 3
```

`3` is not in the HashMap.

Store:

```text
5 → 0
2 → 1
8 → 2
```

---

### Iteration 4

```text
current = 3
index   = 3

needed = 11 - 3
       = 8
```

Check the HashMap:

```text
8 → 2
```

`8` already exists. ✅

Therefore:

```text
needed index  = 2
current index = 3
```

Return:

```text
[2, 3]
```

---

# 📝 Pseudocode

```text
Create an empty HashMap

For every number in nums:

    current = nums[i]

    needed = target - current

    If needed exists in HashMap:
        return [index of needed, current index]

    Otherwise:
        store current → current index
```

---

# ☕ Java Solution

```java
import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

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
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the array once.

HashMap `containsKey()`, `get()`, and `put()` operations take **O(1) average time**.

### Space Complexity

```text
O(n)
```

In the worst case, the HashMap stores up to `n` elements.

---

# 🔑 What I Learned

### 1. Complement Lookup

Instead of checking every possible pair:

```text
needed = target - current
```

Then search for `needed`.

### 2. HashMap Structure

```text
number → index
```

We need the index because Two Sum asks us to return **indices**, not values.

### 3. Check Before Store

The order matters:

```java
if (seen.containsKey(needed)) {
    // match
}

seen.put(current, i);
```

This prevents accidentally using the same array element twice.

---

# 🎤 Interview Explanation

A concise way to explain the approach:

> I iterate through the array once and use a HashMap to store each previously seen number and its index. For every current number, I calculate its complement using `target - current`. If that complement already exists in the HashMap, I return its stored index together with the current index. Otherwise, I store the current number and its index.

---

# 🧠 Mental Reminder

```text
needed = target - current

Calculate needed
      ↓
Check HashMap
      ↓
Found?
 /     \
YES     NO
 ↓       ↓
Return   Store current → index
```

---

## ✅ Progress

- [x] Understand the problem
- [x] Learn the Complement Lookup pattern
- [x] Design the algorithm
- [x] Understand the pseudocode
- [ ] Solve independently on NeetCode
- [ ] Submit successfully
- [ ] Push solution to GitHub
- [ ] Re-solve without help**