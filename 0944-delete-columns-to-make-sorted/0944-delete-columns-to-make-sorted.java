class Solution {
    public int minDeletionSize(String[] strs) {
      if(strs==null||strs.length==0)
            return 0;//base case
        int res=0;//result
        int n=strs[0].length();//for longest column length
        for(int i=0;i<n;i++)
        {
            int j=0;//should be 0 every time i increases
            for(;j<strs.length-1;j++)
            {
                if(strs[j].charAt(i)>strs[j+1].charAt(i))
                    break;
            }
            if(j!=strs.length-1)// j not reach charcter of lowest string since break came
                res++;//one column not sorted found
        }
        return res;
    }
}