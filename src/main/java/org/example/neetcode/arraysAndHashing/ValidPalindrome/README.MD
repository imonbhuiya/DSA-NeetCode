# Valid Palindrome

## Topic
Two Pointers

## Difficulty
Easy

## Pattern
Opposite-Direction Two Pointers

---

## Problem Statement

Given a string `s`, return `true` if it is a palindrome, otherwise return `false`.

A palindrome reads the same forward and backward.

While checking the string:

- Ignore spaces and special characters.
- Consider only letters and digits.
- Ignore uppercase/lowercase differences.

---

## Example

### Input

```text
s = "A man, a plan, a canal: Panama"
```

### Output

```text
true
```

### Explanation

After ignoring spaces, punctuation, and uppercase/lowercase differences:

```text
amanaplanacanalpanama
```

It reads the same forward and backward.

---

# Pattern Explanation

We use **Two Pointers**.

One pointer starts from the beginning:

```java
int left = 0;
```

The other starts from the end:

```java
int right = s.length() - 1;
```

Visual:

```text
r a c e c a r
↑           ↑
left      right
```

We compare characters from both ends and move toward the center.

---

## Main Idea

For every iteration:

```text
1. Check left character
   ↓
   Not letter/digit?
   → left++

2. Check right character
   ↓
   Not letter/digit?
   → right--

3. Both are valid
   ↓
   Convert both to lowercase

4. Compare
   ↓
   Different → return false
   Same      → move both pointers

5. All pairs checked
   ↓
   return true
```

---

## Step-by-Step Walkthrough

Consider:

```text
s = "RaceCar"
```

Start:

```text
R a c e C a r
↑           ↑
L           R
```

Convert both characters to lowercase:

```text
r == r
```

Match, so:

```text
left++
right--
```

Next:

```text
R a c e C a r
  ↑       ↑
  L       R
```

```text
a == a
```

Continue until both pointers reach the middle.

Since no mismatch is found:

```text
return true
```

---

## Important Java Methods

### Check Letter or Digit

```java
Character.isLetterOrDigit(c)
```

Examples:

```text
'A' → true
'7' → true
' ' → false
',' → false
'@' → false
```

### Convert to Lowercase

```java
Character.toLowerCase(c)
```

Example:

```text
'A' → 'a'
'a' → 'a'
```

This allows:

```text
'A' == 'a'
```

after both are converted to lowercase.

---

## Pseudocode

```text
left = 0
right = length - 1

while left < right:

    if left character is not letter/digit:
        left++

    else if right character is not letter/digit:
        right--

    else:
        convert both characters to lowercase

        if characters are different:
            return false

        left++
        right--

return true
```

---

## Java Solution

```java
class Solution {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;

            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;

            } else {

                char leftChar =
                        Character.toLowerCase(s.charAt(left));

                char rightChar =
                        Character.toLowerCase(s.charAt(right));

                if (leftChar == rightChar) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
```

---

## Complexity

### Time Complexity

```text
O(n)
```

Each pointer moves through the string at most once.

### Space Complexity

```text
O(1)
```

We don't create another cleaned string or additional data structure.

---

# Key Learnings

- Two Pointers can start from opposite ends.
- `left++` moves toward the right.
- `right--` moves toward the left.
- `Character.isLetterOrDigit()` helps ignore special characters.
- `Character.toLowerCase()` allows case-insensitive comparison.
- One mismatching pair is enough to return `false`.
- If the loop finishes without finding a mismatch, return `true`.

---

# Interview Explanation

> I use two pointers, one at the beginning and one at the end of the string. I skip characters that are not letters or digits. For valid characters, I convert both to lowercase and compare them. If they are different, I immediately return false. Otherwise, I move both pointers toward the center. If all pairs match, I return true.

---

# Mental Reminder

```text
        TWO POINTERS

left →               ← right

Skip invalid characters
          ↓
Convert to lowercase
          ↓
Compare both sides
       ↙     ↘
    same     different
     ↓           ↓
 move both     false
     ↓
 reach middle
     ↓
    true
```

---

## Re-Solve Plan

- [x] Understand Two Pointers basics
- [x] Solve with guidance
- [x] Test in IDE
- [x] Submit Easy problem
- [ ] Re-solve without help
- [ ] Re-solve during Medium phase revision
- [ ] Explain solution in under 2 minutes