# Valid Anagram

**Topic:** Arrays & Hashing  
**Difficulty:** Easy  
**Pattern:** Frequency Map / HashMap  
**Status:** ✅ Accepted

## Problem

Given two strings `s` and `t`, return `true` if they are anagrams; otherwise return `false`.

An anagram contains the same characters with the same frequencies, although the order may be different.

### Examples

```text
s = "racecar"
t = "carrace"
Output: true
```

```text
s = "jar"
t = "jam"
Output: false
```

## Pattern — Frequency Map

```text
First string  → +1
Second string → -1

All counts = 0 → true
Any count ≠ 0 → false
```

## Main Idea

1. If the lengths are different, return `false`.
2. Create a `HashMap<Character, Integer>`.
3. Process `s`: increase each character count by 1.
4. Process `t`: decrease each character count by 1.
5. Check all values in the HashMap.
6. If every value is 0, return `true`.

## Visual Flow

```text
START
  ↓
Check lengths
  ↓
Different? ──YES──> false
  │
  NO
  ↓
Create HashMap
  ↓
s characters → +1
t characters → -1
  ↓
Check all counts
  ↓
Any count != 0? ──YES──> false
  │
  NO
  ↓
true
```

## Step-by-Step Example

```text
s = "cat"
t = "act"

After processing both:

c → 0
a → 0
t → 0

Result → true
```

## Pseudocode

```text
FUNCTION isAnagram(s, t)

    IF length(s) != length(t)
        RETURN false

    CREATE empty HashMap

    FOR each index i
        PROCESS s[i] with +1
        PROCESS t[i] with -1

    FOR every count in HashMap
        IF count != 0
            RETURN false

    RETURN true
```

## Java Solution

```java
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char letter = s.charAt(i);

            if (charCounts.containsKey(letter)) {
                int oldCount = charCounts.get(letter);
                int newCount = oldCount + 1;
                charCounts.put(letter, newCount);
            } else {
                charCounts.put(letter, 1);
            }

            char letter2 = t.charAt(i);

            if (charCounts.containsKey(letter2)) {
                int oldCount = charCounts.get(letter2);
                int newCount = oldCount - 1;
                charCounts.put(letter2, newCount);
            } else {
                charCounts.put(letter2, -1);
            }
        }

        for (int count : charCounts.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
```

## Complexity

**Time:** `O(n)`

We process the strings linearly. HashMap lookup/update operations are `O(1)` on average.

**Space:** `O(n)` for the general HashMap pattern.

For this specific NeetCode problem, the strings contain only lowercase English letters, so there can be at most 26 keys. Under that constraint, auxiliary space is `O(1)`.

## Key Learnings

```text
HashMap<Character, Integer>
Character → Frequency
```

```text
containsKey() → CHECK
get()         → GET
put()         → STORE / UPDATE

GET → CHANGE → PUT
```

Core idea:

```text
s → +1
t → -1
matching frequencies cancel
all 0 → true
```

## Interview Explanation

First, I check whether the strings have the same length because strings with different lengths cannot be anagrams. Then I use a HashMap to track character frequencies. I increase the count for characters from the first string and decrease the count for characters from the second string. Finally, I check all frequency values. If every count is zero, the strings are anagrams; otherwise, they are not.

## Mental Reminder

```text
Same length?
     ↓
Frequency Map
     ↓
s → +1
t → -1
     ↓
All counts 0?
  YES → true
  NO  → false
```

## Re-Solve Plan

- ✅ First solve — completed
- ⬜ Re-solve without notes
- ⬜ Re-solve without previous code
- ⬜ Explain solution aloud
- ⬜ Write a shorter version later

## Problem Link

https://neetcode.io/problems/is-anagram/question?list=blind75
