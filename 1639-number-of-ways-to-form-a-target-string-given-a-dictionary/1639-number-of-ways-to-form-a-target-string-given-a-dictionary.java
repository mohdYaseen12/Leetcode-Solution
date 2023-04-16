class Solution {
    public int numWays(String[] words, String target) {
         int iLength = target.length();
        int jLength = words[0].length();
        long[][] ij = new long[iLength][jLength];

        int[][] charCounts = new int[jLength][26];

        for (String word : words) {
            for (int i = 0; i < jLength; i++) {
                charCounts[i][word.charAt(i) - 'a']++;
            }
        }


        for (int i=0; i < target.length(); i++) {
            char c = target.charAt(i);
            // calculate for all j's up to now
            int charsLeft = iLength - i - 1;
            for (int j=i; j < jLength - charsLeft; j++) {
                long matches = charCounts[j][c - 'a'];
                if (i > 0) {
                    matches = (matches * ij[i -1][j -1]) % 1000000007;
                }
                if (j > i) {
                    matches = (matches + ij[i][j - 1]) % 1000000007;
                }
                ij[i][j] = matches % 1000000007;
            }
        }
        return (int) ij[iLength -1][jLength -1];
    }
}