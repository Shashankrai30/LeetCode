class Solution {
    class pair{
        int row;
        int col;
        int level;
        public pair(int row,int col,int level){
            this.row=row;
            this.col=col;
            this.level=level;
        }
    }

    int dr[]={1,-1,0,0};
    int dc[]={0,0,1,-1};
    int rowl;
    int coll;

    public int[][] highestPeak(int[][] isWater) {
       rowl=isWater.length;
       coll=isWater[0].length;

       Queue<pair> q=new LinkedList<>();
       boolean visited[][]=new boolean[rowl][coll];

       for(int i=0;i<rowl;i++){
        for(int j=0;j<coll;j++){
            if(isWater[i][j]==1){
                q.offer(new pair(i,j,0));
                isWater[i][j]=0;
                visited[i][j]=true;
            }
        }
       } 

       while(!q.isEmpty()){
        pair curr=q.poll();
        int row=curr.row;
        int col=curr.col;
        int level=curr.level;

        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && !visited[nrow][ncol]){
                isWater[nrow][ncol]=level+1;
                q.offer(new pair(nrow,ncol,level+1));
                visited[nrow][ncol]=true;
            }
        }
       }

       return isWater;
    }
}