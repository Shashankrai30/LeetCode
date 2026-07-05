class Solution {
    public int maxProfit(int[] prices) {
        int max[] = new int[prices.length];

        max[prices.length-1]=prices[prices.length-1];

        for(int j=prices.length-2;j>=0;j--){
            max[j]=Math.max(max[j+1],prices[j]);
        }

        int min=0;

        for(int i=0;i<prices.length;i++){
            int profit=max[i]-prices[i];
            min=Math.max(min,profit);
        }

        return min;
    }
}