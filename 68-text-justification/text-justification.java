class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int tl = 0, n = 0, s = 0, e = 0;
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (tl + word.length() + n > maxWidth) {
                if (n == 1) {
                    line.append(words[s]);
                    line.append(" ".repeat(maxWidth - line.length()));
                } else {
                    int spaces = (maxWidth - tl) / (n - 1);
                    int extra = (maxWidth - tl) % (n - 1);

                    for (int i = s; i < e - 1; i++) {
                        line.append(words[i]);
                        line.append(" ".repeat(spaces));
                        if (extra > 0) {
                            line.append(" ");
                            extra--;
                        }
                    }
                    line.append(words[e - 1]);
                }

                ans.add(line.toString());
                line = new StringBuilder();
                s = e;
                tl = 0;
                n = 0;
            }
            tl += word.length();
            n++;
            e++;
        }
        for (int i = s; i < words.length; i++) {
            line.append(words[i]);
            if (i < words.length - 1) {
                line.append(" ");
            }
        }

        line.append(" ".repeat(maxWidth - line.length()));
        ans.add(line.toString());

        return ans;
    }
}