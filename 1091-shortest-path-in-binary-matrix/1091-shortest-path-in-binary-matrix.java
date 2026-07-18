class Solution {
    class pair{
        int row;
        int col;
        int step;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.step=dist;
        }
    }

    int rowl;
    int coll;
    int dr[] = {1,-1,0,0,1,1,-1,-1};
    int dc[] = {0,0,1,-1,-1,1,-1,1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0]!=0) return -1;
        
        rowl=grid.length;
        coll=grid[0].length;

        int dist[][] = new int[rowl][coll];

        for(int arr[]:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.step-b.step);

        pq.offer(new pair(0,0,1));
        dist[0][0] = 1;

        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int row=curr.row;
            int col=curr.col;
            int step=curr.step;

            for(int i=0;i<8;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]==0 && dist[nrow][ncol]>step+1){
                    pq.offer(new pair(nrow,ncol,step+1));
                    dist[nrow][ncol]=step+1;
                }
            }
        }

        return (dist[rowl-1][coll-1]==Integer.MAX_VALUE)?-1:dist[rowl-1][coll-1];
    }
}