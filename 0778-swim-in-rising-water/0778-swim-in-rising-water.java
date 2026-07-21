class Solution {
    class pair{
        int row;
        int col;
        
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    public int swimInWater(int[][] grid) {
        rowl=grid.length;
        coll=grid[0].length;

        int low=grid[0][0];
        int high=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                high=Math.max(high,grid[i][j]);
            }
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            Queue<pair> q = new LinkedList<>();
            q.offer(new pair(0,0));

            boolean vis[][] = new boolean[rowl][coll];
            vis[0][0]=true;


            while(!q.isEmpty()){
                pair curr=q.poll();
                int row=curr.row;
                int col=curr.col;

                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];

                    if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && mid>=grid[nrow][ncol] && !vis[nrow][ncol]){
                        q.offer(new pair(nrow,ncol));
                        vis[nrow][ncol]=true;
                    }
                }
            }
            if(vis[rowl-1][coll-1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }
}