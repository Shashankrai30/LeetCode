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

    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    public int orangesRotting(int[][] grid) {

        rowl=grid.length;
        coll=grid[0].length;

        int time[][] = new int[grid.length][grid[0].length];
        
        for(int arr[]:time){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        int oranges=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    pq.offer(new pair(i,j,0));
                    time[i][j]=0;
                }
                if(grid[i][j]==1){
                    oranges++;
                }
            }
        }

        int ans=0;

        while(!pq.isEmpty()){
            pair curr= pq.poll();
            int r=curr.row;
            int c=curr.col;
            int dist=curr.dist;

            if(grid[r][c]==1){
                oranges--;
            }

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]==1 && time[nrow][ncol]>dist+1){
                    pq.offer(new pair(nrow,ncol,dist+1));
                    time[nrow][ncol] = dist+1;
                    ans=Math.max(ans,dist+1);
                }
            }           
        }

        if(oranges!=0){
                return -1;
        }

        return ans;
    }
}