class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        int even=0;
        int odd=0;

        for(int i=1;i<=2*n;i++){
            if(i%2==0){
                even+=i;
            }
            else{
                odd+=i;
            }
        }

        return gcd(odd,even);
    }

    int gcd(int x,int y){

        if(y==0) return x;

        return gcd(y,x%y);
    }
}