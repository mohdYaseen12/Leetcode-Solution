class Solution {
    public int maximumDetonation(int[][] bombs) {
        int maxExplosions=0;
        boolean vis[]=new boolean[bombs.length];
        for(int i=0;i<bombs.length;i++){
            if(!vis[i]){
                maxExplosions=Math.max(maxExplosions,
                                get_ans(bombs,i,vis,new boolean[bombs.length]));
            }
        }
        return maxExplosions;
    }
    private int get_ans(int [][]bombs,int i,boolean []vis,boolean []currVis){
        int explosions=1;
        currVis[i]=vis[i]=true;
        for(int j=0;j<bombs.length;j++){
            if(!currVis[j] && isInRange(bombs[i],bombs[j]))
                explosions+=get_ans(bombs,j,vis,currVis);
        }
        return explosions;
    }
    private boolean isInRange(int srcBomb[],int desBomb[]){
        return srcBomb[2]>=Math.sqrt(Math.pow(srcBomb[0]-desBomb[0],2)+
                            Math.pow(srcBomb[1]-desBomb[1],2));
    }
}