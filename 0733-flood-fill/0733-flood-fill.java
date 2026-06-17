class Solution {

    int dr[]={1,-1,0,0};
    int dc[]={0,0,1,-1};
    int rowl;
    int coll;   

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        rowl=image.length;
        coll=image[0].length;
        
        boolean visited[][] = new boolean[rowl][coll];

        helper(sr,sc,image,color,image[sr][sc],visited);

        return image;
    }

    void helper(int row,int col,int image[][],int color,int curr,boolean visited[][]){
        if(row<0 || col<0 || row>=rowl || col>=coll || image[row][col]!=curr || visited[row][col]){
            return;
        }

        image[row][col]=color;
        visited[row][col]=true;

        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];

            helper(nrow,ncol,image,color,curr,visited);
        }
    }
}