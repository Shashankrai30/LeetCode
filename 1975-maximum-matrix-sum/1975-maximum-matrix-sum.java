class Solution {
    public long maxMatrixSum(int[][] matrix) {

        int negative=0;
        long sum=0;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                sum=sum+Math.abs(matrix[i][j]);

                min=Math.min(min,Math.abs(matrix[i][j]));

                if(matrix[i][j]<0){
                    negative++;
                }
            }
        }

        if(negative%2==0 ) return sum;

        return sum-2L*min;
    }
}