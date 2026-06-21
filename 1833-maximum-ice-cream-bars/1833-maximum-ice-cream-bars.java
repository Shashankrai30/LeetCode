class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);

        int i=0;
        
        while(i<costs.length && coins>0){
            if(costs[i]<=coins){
                coins=coins-costs[i];
                i++;
            }
            else{
                break;
            }
        }

        return i;
    }
}