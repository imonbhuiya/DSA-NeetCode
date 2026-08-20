class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        java.util.HashMap<Character, Integer> charCounts = new java.util.HashMap<>();

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