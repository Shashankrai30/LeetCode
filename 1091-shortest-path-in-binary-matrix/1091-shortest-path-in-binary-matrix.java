class Solution {
    class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    int dr[]={1,-1,0,0,1,1,-1,-1};
    int dc[]={0,0,1,-1,1,-1,1,-1};
    int rowl;
    int coll;

    public int shortestPathBinaryMatrix(int[][] grid) {
        rowl=grid.length;
        coll=grid[0].length;

        boolean visited[][]=new boolean[rowl][coll];

        if(grid[0][0]==1) return -1;

        Queue<pair> q= new LinkedList<>();

        q.offer(new pair(0,0,1));
        visited[0][0]=true;

        while(!q.isEmpty()){
            pair curr=q.poll();

            int r=curr.row;
            int c=curr.col;
            int dist=curr.dist;

            if(r==rowl-1 && c==coll-1){
                return dist;
            }

            for(int i=0;i<8;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]==0 && !visited[nrow][ncol]){
                    visited[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol,dist+1));
                }
            }
        }
        return -1;
    }
}