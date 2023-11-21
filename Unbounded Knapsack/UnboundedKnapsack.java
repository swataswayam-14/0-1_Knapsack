import java.util.*;
public class UnboundedKnapsack{
    public static int unboundedKnapsack(int wt[] , int val[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;//initialisation for the row having 0 items
        }
        for(int j=0;j<dp.length;j++){
            dp[0][j] = 0; // initialisation for the column having 0 knapsack weight
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1]<=j){//valid
                    dp[i][j] =Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(unboundedKnapsack(wt, val, W));
    }
}