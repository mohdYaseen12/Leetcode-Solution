class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }
        
        for(int card : deck){
            // first pop from queue
            ans[q.remove()] = card;
            if(!q.isEmpty()){
                q.add(q.remove());
            }
        }
        return ans;
    }
}