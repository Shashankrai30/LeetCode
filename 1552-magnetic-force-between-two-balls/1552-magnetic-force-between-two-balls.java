class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
       int i=Integer.MAX_VALUE;
       int j=position[position.length-1]-position[0];

       for(int ind=0;ind<position.length-1;ind++){
        i=Math.min(i,position[ind+1]-position[ind]);
       } 

       while(i<=j){
        int mid=i+(j-i)/2;

        int count=1;
        int place=position[0];

        for(int ind=1;ind<position.length;ind++){
            if(position[ind]-place>=mid){
                count++;
                place=position[ind];
            }
        }

        if(count>=m){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
       }

       return j;
    }
}