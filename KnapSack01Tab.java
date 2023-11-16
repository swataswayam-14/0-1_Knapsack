import java.util.*;
public class KnapSack01Tab {
    public static int knapsackTabulation(int val[] , int wt[], int W){
        
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i<n;i++){
            dp[i][0] = 0;// initialising the oth column signifying there is 0 weight left in the knapsack with 0
        }
        for(int j = 0; j< dp[0].length; j++){
            dp[0][j] = 0; //initialising the 0th row of dp array which signifyes that there is no item present to be put in the knapsack
        }

        for(int i = 1 ; i<dp.length ; i++){
            int v = val[i-1];
            int w = wt[i-1];
            for(int j=1;j<dp[0].length;j++){
                if(w<=j){
                    //valid condition
                    //include
                    int incProfit = v + dp[i-1][j-w];
                    //exclude
                    int exProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, exProfit);
                }
                else{
                    //invalid condition
                    int exProfit = dp[i-1][j];
                    dp[i][j] = exProfit;
                }
            }
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsackTabulation(val, wt, W));
    }
}
//The time complexity of this code is O(n*W), where n : no. of items , W : total capacity of the knapsack