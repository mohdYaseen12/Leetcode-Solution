class Solution {
    public int maxValue(int n, int i, int maxSum) {
        long right=n-i-1;
      long left=i;
      long l=1;
      long h=maxSum;
      long r=0;
      while(l<=h){
          long mid=((h-l)/2)+l;
          long leftsum=0,rightsum=0,el=mid-1;
          if(right<=el){
              rightsum=(el*(el+1)/2)-((el-right)*((el-right)+1)/2);
          }else
              rightsum=(el*(el+1)/2)+(right-el);

        if(left<=el){
            leftsum=(el*(el+1)/2)-((el-left)*((el-left)+1)/2);
        }else{
            leftsum=(el*(el+1)/2)+(left-el);

        }
        long sum=leftsum+rightsum+mid;
        if(sum<=(long)maxSum){
           
            l=mid+1;
            r=mid;
        }else{
            h=mid-1;
        }
      }
      return (int)r;
    }
}