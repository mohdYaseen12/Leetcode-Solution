class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pair = new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            pair[i] = new int[]{nums2[i],nums1[i]};
        }
        Arrays.sort(pair,(a,b) -> b[0]-a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0;
        long sum = 0;
        for(int i=0;i<pair.length;i++){
            int[] temp = pair[i];
            pq.add(temp[1]);
            sum += temp[1];

            if(pq.size() > k){
                sum -= pq.poll();
            }
            if(k == pq.size()){
                ans = Math.max(ans,sum*temp[0]);
            }
        }
        return ans;
    }
}