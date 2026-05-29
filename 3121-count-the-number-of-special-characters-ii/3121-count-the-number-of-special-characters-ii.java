class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> special = new HashSet<>();
        HashSet<Character> invalid = new HashSet<>();

        int count = 0;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                char temp = (char)(ch - 'a' + 'A');

                if (set.contains(temp)) {
                    if (special.contains(temp)) {
                        count--;
                        special.remove(temp);
                    }
                    invalid.add(temp);
                }

            } else {

                char temp = (char)(ch - 'A' + 'a');

                if (set.contains(temp)
                        && !special.contains(ch)
                        && !invalid.contains(ch)) {
                    count++;
                    special.add(ch);
                }
            }

            set.add(ch);
        }

        return count;
    }
}