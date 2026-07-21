class Solution {
    class pair{
        int row;
        int col;
        int cost;
        public pair(int row,int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
    }
    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    public int minCost(int[][] grid) {

        rowl=grid.length;
        coll=grid[0].length;
        int distance[][] = new int[rowl][coll];

        for(int d[]:distance){
            Arrays.fill(d,(int)1e9);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.offer(new pair(0,0,0));
        distance[0][0]=0;

        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int r=curr.row;
            int c=curr.col;
            int cost=curr.cost;

            int row;
            int col;

            if(grid[r][c]==1){
                row=r;
                col=c+1;
            }
            else if(grid[r][c]==2){
                row=r;
                col=c-1;
            }
            else if(grid[r][c]==3){
                row=r+1;
                col=c;
            }
            else{
                row=r-1;
                col=c;
            }

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll){
                    if((nrow==row && ncol==col) && distance[nrow][ncol]>cost){
                        pq.offer(new pair(nrow,ncol,cost));
                        distance[nrow][ncol] = cost;
                    }
                    else if(distance[nrow][ncol]>cost+1){
                        pq.offer(new pair(nrow,ncol,cost+1));
                        distance[nrow][ncol] = cost+1;
                    }
                }
            }
        }

        return distance[rowl-1][coll-1];
    }
}