class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
       int ind=0;
       int count=0;

       for(int i=0;i<mat.length;i++){
        int temp=0;
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]==1) temp++;
        }
        if(temp>count){
            ind=i;
            count=temp;
        }
       } 

       return new int[]{ind,count};
    }
}