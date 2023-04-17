class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = -1;
        for(int candy : candies){
            if(candy > max) max = candy;
        }
        
        for(int candy : candies){
            if(candy + extraCandies >= max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}