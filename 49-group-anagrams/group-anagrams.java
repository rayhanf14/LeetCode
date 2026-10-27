
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            String key = Arrays.toString(freq);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }

        for (List<String> v : map.values()) {
            ans.add(v);
        }

        return ans;
    }
}
