class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int len = costs.length;
        
        int ice = 0;
        while(ice < len && costs[ice] <= coins){
            coins = coins - costs[ice];
            ice++;
        }
        return ice;
    }
}