import java.util.*;
public class KnapSack01Memo {

    public static int knapsack(int val[] , int wt[] , int n , int W , int dp[][]){
        if(W==0 || n==0){
            return 0;
        }

        //checking wether dp[n][W] is already calculated or not
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(wt[n-1]<=W){//valid
            //include
            int ans1 = val[n-1] + knapsack(val, wt, n-1, W-wt[n-1], dp);

            //exclude
            int ans2 = knapsack(val, wt,n-1, W, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        //not valid case 
        else{
            dp[n][W] = knapsack(val, wt, n-1, W, dp);
            return dp[n][W];
        }
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0 ; i<dp.length;i++){
            for(int j = 0 ;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("The maximum profit is "+knapsack(val, wt, val.length, W, dp));
        
    }
}
//the time complexity is O(n*W), where n = total number of elements ,W = total capacity of knapsack
