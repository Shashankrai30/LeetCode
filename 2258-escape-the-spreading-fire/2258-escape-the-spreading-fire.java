class Solution {
    class pair{
        int row;
        int col;
        int time;
        public pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    public int maximumMinutes(int[][] grid) {
        rowl=grid.length;
        coll=grid[0].length;

        int time[][] = new int[rowl][coll];

        for(int arr[]:time){
            Arrays.fill(arr,(int)1e9);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]==1){
                    pq.offer(new pair(i,j,0));
                    time[i][j]=0;
                }
            }
        }

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int row=curr.row;
            int col=curr.col;
            int t=curr.time;

            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]==0 && time[nrow][ncol]>t+1){
                    pq.offer(new pair(nrow,ncol,t+1));
                    time[nrow][ncol] = t+1;
                }
            }
        }

        int low=0;
        int high=time[0][0];

        while(low<=high){
            int mid=low+(high-low)/2;

            // int t[][] = new int[rowl][coll];

            // for(int arr[]:t){
            //     Arrays.fill(arr,(int)1e9);
            // }

            boolean visited[][] = new boolean[rowl][coll];

            PriorityQueue<pair> p = new PriorityQueue<>((a,b)->a.time-b.time);
            
            if(mid<time[0][0]){
                p.offer(new pair(0,0,mid));
                // t[0][0]=mid;
                visited[0][0]=true;
            }

            if(time[0][0]==1e9){
                p.offer(new pair(0,0,mid));
                // t[0][0]=mid;
                visited[0][0]=true;
            }

            while(!p.isEmpty()){
                pair curr = p.poll();
                int row=curr.row;
                int col=curr.col;
                int t=curr.time;

                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];

                    if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]!=2 && !visited[nrow][ncol]){
                       if(time[nrow][ncol] == 1e9){
                          p.offer(new pair(nrow,ncol,t+1));
                          visited[nrow][ncol]=true;
                       }
                       else if(nrow==rowl-1 && ncol==coll-1){
                           if(time[nrow][ncol] >= t+1){
                             p.offer(new pair(nrow,ncol,t+1));
                             visited[nrow][ncol]=true;
                            }
                        }
                        else{
                          if(time[nrow][ncol] > t+1){
                            p.offer(new pair(nrow,ncol,t+1));
                            visited[nrow][ncol]=true;
                          }
                        }
                    }
                }
            }
            if(visited[rowl-1][coll-1]){
                    low=mid+1;
            }
            else{
                    high=mid-1;
            }
        }

        return high;
    }
}