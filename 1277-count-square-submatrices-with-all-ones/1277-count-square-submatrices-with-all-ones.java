class Solution {
    public int countSquares(int[][] matrix) {
       int count=0;

       for(int i=0;i<matrix.length;i++){
         for(int j=0;j<matrix[0].length;j++){
            for(int size=1;size<=matrix.length;size++){
                if(valid(i,j,size,matrix)){
                    count++;
                }
                else{
                    break;
                }
            }
         }
       } 
       return count;
    }

    boolean valid(int row,int col,int size,int mat[][]){
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(i>=mat.length || j>=mat[0].length || mat[i][j]==0) return false;
            }
        }
        return true;
    }
}