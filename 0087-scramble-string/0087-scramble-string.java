class Solution {
        HashMap<String, Boolean> dp;
    private boolean solve(String s1, String s2) {
        if (s1.equals(s2) ) {
            return true;
        }

        if (s1.length() <= 1) {
            return false;
        }
        String key = s1+"-" + s2;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int n = s1.length();
        boolean check = false;
        for (int i = 1; i < n ; i++) {
            boolean swap = solve(s1.substring(0, i), s2.substring(n-i)) && solve(s1.substring(i), s2.substring(0, n - i));
            boolean unswap = solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i), s2.substring(i));
            if (swap || unswap) {
                check = true;
                break;
            }
        }
        dp.put(key, check);
        return check;
    }
    public boolean isScramble(String s1, String s2) {
         if (s1.equals(s2)) {
            return true;
        }
        dp = new HashMap<>();
        return solve(s1, s2);
    }
}