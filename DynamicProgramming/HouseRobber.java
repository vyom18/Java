#You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

#Given an integer array prices representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
#Only function is defined here
class Solution {
    public int rob(int[] prices) {
        int dp[][]=new int[((prices.length+1)/2)+1][prices.length+1];
       // dp[0]=0;
        System.out.println(((prices.length+1)/2)+" "+(prices.length+1));
        for(int i=0;i<=(prices.length+1)/2;i++)
        {
           for(int j=0;j<=prices.length;j++)
           {
               if(i==0 || j==0)
               {
                   dp[i][j]=0;
               }
               else if(i==1 && j==1)
               {
                   dp[1][1]=prices[0];
               }
               else if((j+1)/2<i)
               {
                   dp[i][j]=dp[i-1][j];
               }
               else
               {
               dp[i][j]=Math.max(prices[j-1]+dp[i-1][j-2],dp[i][j-1]);
               }
               
               }
           }
        return dp[(prices.length+1)/2][prices.length];
}
}
