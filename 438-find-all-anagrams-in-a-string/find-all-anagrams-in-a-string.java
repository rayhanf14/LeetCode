class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int[] freq = new int[26];
        for (char c : p.toCharArray())
            freq[c - 'a']++;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'a']--;
            if (r - l + 1 > p.length()) {
                freq[s.charAt(l) - 'a']++;
                l++;
            }
            if (r - l + 1 == p.length()) {
                boolean isAnagram = true;
                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) ans.add(l);
            }
        }

        return ans;
    }
}