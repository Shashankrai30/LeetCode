class Solution {
    class pair{
        int row;
        int col;
        int health;
        public pair(int r,int c,int h){
            this.row=r;
            this.col=c;
            this.health=h;
        }
    }
    int dr[]={1,-1,0,0};
    int dc[]={0,0,1,-1};
    int rowl;
    int coll;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        rowl=grid.size();
        coll=grid.get(0).size();

        Queue<pair> q= new LinkedList<>();
        q.offer(new pair(0,0,health-grid.get(0).get(0)));

        boolean visited[][][] = new boolean[rowl][coll][health+1];
        visited[0][0][health-grid.get(0).get(0)]=true;

        while(!q.isEmpty()){
            pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int rem=curr.health;

            if(row==rowl-1 && col==coll-1){
                return true;
            }

            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && rem-grid.get(nrow).get(ncol)>=1 && !visited[nrow][ncol][rem-grid.get(nrow).get(ncol)]){

                    int nrem=rem-grid.get(nrow).get(ncol);
                    visited[nrow][ncol][nrem]=true;
                    q.offer(new pair(nrow,ncol,nrem));
                }
            }
        }

        return false;
    }
}