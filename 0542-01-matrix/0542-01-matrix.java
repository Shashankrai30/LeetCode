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
    int dr[]= {1,-1,0,0};
    int dc[]= {0,0,1,-1};

    public int[][] updateMatrix(int[][] mat) {

        rowl=mat.length;
        coll=mat[0].length;

        int ans[][] = new int[mat.length][mat[0].length];

        for(int arr[]:ans){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){

                if(mat[i][j]==0){
                    pq.offer(new pair(i,j,0));
                    ans[i][j]=0;
                }
            }
        }

        while(!pq.isEmpty()){
            pair curr= pq.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && mat[nrow][ncol]==1 && ans[nrow][ncol]>d+1){
                    pq.offer(new pair(nrow,ncol,d+1));
                    ans[nrow][ncol] = d+1;
                }
            }
        }

        return ans;
    }
}