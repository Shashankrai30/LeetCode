class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;

        int len=flowerbed.length;

        if(len==1){
           return (flowerbed[0]==0 && --n ==0); 
        }

        if(flowerbed[0]==0 && flowerbed[1]==0){
            n--;
            flowerbed[0]=1;
        }

        for(int i=1;i<len-1;i++){
            if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                n--;
                flowerbed[i]=1;
            }

            if(n==0) return true;
        }

        if(flowerbed[len-1]==0 && flowerbed[len-2]==0){
            n--;
        }

        return (n==0);
    }
}