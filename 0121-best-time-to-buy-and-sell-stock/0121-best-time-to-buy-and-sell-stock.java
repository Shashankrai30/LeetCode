class Solution {
    public int maxProfit(int[] prices) {
        int pre[] =new int[prices.length];
        pre[prices.length-1]=prices[prices.length-1];

        for(int i=prices.length-2;i>=0;i--){
            pre[i]=Math.max(prices[i],pre[i+1]);
        }

        int ans=0;
        for(int i=0;i<prices.length;i++){
            ans=Math.max(ans,pre[i]-prices[i]);
        }

        return ans;
    }
}