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

    public int minimumEffortPath(int[][] heights) {
        
        rowl=heights.length;
        coll=heights[0].length;

        int low=0;
        int high=0;

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                high=Math.max(high,heights[i][j]);
            }
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            int dist[][] = new int[rowl][coll];

            for(int arr[]:dist){
                Arrays.fill(arr,(int)1e9);
            }
            
            Queue<pair> pq = new LinkedList<>();
            pq.offer(new pair(0,0));
            dist[0][0]=0;

            while(!pq.isEmpty()){
                pair curr = pq.poll();
                int row=curr.row;
                int col=curr.col;

                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];

                    if(nrow<rowl && ncol<coll && nrow>=0 && ncol>=0 && Math.abs(heights[row][col]-heights[nrow][ncol])<=mid && Math.abs(heights[row][col]-heights[nrow][ncol])<dist[nrow][ncol]){
                        pq.offer(new pair(nrow,ncol));
                        dist[nrow][ncol]=Math.abs(heights[row][col]-heights[nrow][ncol]);
                    }
                }
            }
            if(dist[rowl-1][coll-1]<1e9){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }
}