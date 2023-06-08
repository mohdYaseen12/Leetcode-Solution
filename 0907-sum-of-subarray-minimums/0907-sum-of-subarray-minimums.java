class Solution {
    public int sumSubarrayMins(int[] arr) {
         int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        long sumOfMinimum = 0;
        int n = arr.length;

        for(int i=0; i<=n;i++){

            while(!stack.empty() && (i==n || arr[stack.peek()] >= arr[i])){

                    int index = stack.pop();
                    int ngei = i;
                    int sgei = stack.empty() ? -1 :stack.peek();

                    long leftBoundary = index - sgei ;
                    long rightBoundary = ngei - index;
                    
                    long value = arr[index];
                    long contribution = (rightBoundary*leftBoundary*value)%MOD;

                    sumOfMinimum += contribution%MOD;
                    sumOfMinimum%=MOD;
                    
            }
            stack.push(i);

        }

        return (int)sumOfMinimum;

    }
}