import java.util.*;
public class KnapSack01Rec{

    public static int knapsack(int val[] , int wt[] , int n , int W){
        if(W==0 || n == 0){
            return 0; // base case: If no items present (n=0) or No more capacity (W=0)
        }
        if(wt[n-1] <= W){//valid condition
            //include
            int ans1 = val[n-1] + knapsack(val, wt, n-1, W-wt[n-1]);
            //exclude
            int ans2 = knapsack(val, wt , n-1 , W);
            return Math.max(ans1, ans2);
        }else{
            return knapsack(val, wt, n-1, W);
        }
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7; //maximum capacity of knapsack
        System.out.println("The maximum profit is : "+knapsack(val, wt, val.length, W));
        //the output should be 75
    }
}