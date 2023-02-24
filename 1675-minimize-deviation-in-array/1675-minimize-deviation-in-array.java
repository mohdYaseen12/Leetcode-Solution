class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num % 2 != 0){
                num *= 2;
            }
            min = Math.min(min,num);
            pq.add(num);
        }
        
        int diff = Integer.MAX_VALUE;
        while(pq.peek() % 2 == 0){
            int tmp = pq.remove();
            diff = Math.min(diff, tmp - min);
            min = Math.min(tmp/2,min);
            pq.add(tmp/2);
        }
        return Math.min(diff,pq.peek() - min);
    }
}