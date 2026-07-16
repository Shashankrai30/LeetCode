class Solution {
    int rowl;
    int coll;
    int dr[]={1,-1,0,0};
    int dc[]={0,0,1,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color) return image;
        
        rowl=image.length;
        coll=image[0].length;;

        dfs(sr,sc,color,image[sr][sc],image);
        return image;
    }

    void dfs(int row,int col,int color,int cur,int image[][]){

        image[row][col]=color;

        for(int i=0;i<4;i++){

            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && image[nrow][ncol]==cur){
                dfs(nrow,ncol,color,cur,image);
            }
        }
    }
}