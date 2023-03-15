class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0d;
        for(int sal : salary){
            sum += sal;
            min = Math.min(sal,min);
            max = Math.max(sal,max);
        }
        
        return (double)((sum-min-max)/(salary.length-2));
        
    }
}