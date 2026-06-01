class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int i=cost.length-1;

        int totalcost=0;
        int count=0;

        while(i>=0){
            if(count==2){
                count=0;
            }
            else{
                totalcost+=cost[i];
                count++;
            }
            i--;
        }

        return totalcost;
    }
}