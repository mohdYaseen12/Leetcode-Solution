class Solution {
    boolean isSatisfied(int[] tfreq, int[] sfreq){
		for(int i=0;i<123;i++){
			if(tfreq[i] > sfreq[i]) return false;
		}
		return true;
	}
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int start = 0;
		int end = 0;
		int startAns = -1;
		int endAns = -1;
		int ans = Integer.MAX_VALUE;
		int[] tfreq = new int[123];
		for(int i=0;i<t.length();i++) tfreq[t.charAt(i)]++;

		int[] sfreq = new int[123];
		while(end  < s.length()){
			//1. Expansion
			sfreq[s.charAt(end)]++;
			end++;

			while(start < end && isSatisfied(tfreq,sfreq)){
				if(ans > end - start){
					ans = end - start;
					startAns = start;
					endAns = end;
				}
				sfreq[s.charAt(start)]--;
				start++;
			}
			
		}
		return ans == Integer.MAX_VALUE ? "" : s.substring(startAns, endAns);
        
    }
}