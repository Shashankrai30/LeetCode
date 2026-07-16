class Solution {
    int rowl;
    int coll;
    int dr[]={1,-1,0,0};
    int dc[]={0,0,1,-1};
    public int numIslands(char[][] grid) {
        rowl=grid.length;
        coll=grid[0].length;
        boolean visited[][] = new boolean[rowl][coll];

        int count=0;

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int row,int col,boolean visited[][],char grid[][]){
        visited[row][col]=true;

        for(int i=0;i<4;i++){

            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]=='1' && !visited[nrow][ncol] ){
                dfs(nrow,ncol,visited,grid);
            }
        }
    }
}