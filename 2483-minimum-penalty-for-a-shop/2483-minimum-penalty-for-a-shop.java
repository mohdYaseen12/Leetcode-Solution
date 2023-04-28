class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefPenalN = new int[n+1];
        int[] suffPenalY = new int[n+1];
        int penal = 0;
        for(int i=0;i<n;i++){
            char ch = customers.charAt(i);
            prefPenalN[i] = penal;
            if(ch == 'N') penal++;
        }
        prefPenalN[n] = penal;
        penal = 0;
        for(int i=n-1;i>=0;i--){
            char ch = customers.charAt(i);
            if(ch == 'Y') penal++;
            suffPenalY[i] = penal;
        }
        suffPenalY[n] = 0;
        
        int ans = -1;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            if(suffPenalY[i] + prefPenalN[i] < mini){
                mini = suffPenalY[i] + prefPenalN[i];
                ans = i;
            }
        }
        return ans;
    }
}