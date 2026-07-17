class Solution {
    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    int mrow;
    int mcol;
    public int[][] findFarmland(int[][] land) {

       rowl=land.length;
       coll=land[0].length;
       boolean visited[][] = new boolean[rowl][coll];

       ArrayList<ArrayList<Integer>> list = new ArrayList<>();

       for(int i=0;i<rowl;i++){
        for(int j=0;j<coll;j++){
            if(!visited[i][j] && land[i][j]==1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                mrow=i;
                mcol=j;
                dfs(i,j,land,visited);
                temp.add(mrow);
                temp.add(mcol);
                list.add(temp);
            }
        }
       } 

       int ans[][] = new int[list.size()][4];

       for(int i=0;i<list.size();i++){
         ans[i][0] = list.get(i).get(0);
         ans[i][1] = list.get(i).get(1);
         ans[i][2] = list.get(i).get(2);
         ans[i][3] = list.get(i).get(3);
       }

       return ans;
    }

    void dfs(int row,int col,int land[][],boolean visited[][]){

        visited[row][col] = true;

        if(mrow<=row && mcol<=col){
            mrow=row;
            mcol=col;
        }

        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && !visited[nrow][ncol] && land[nrow][ncol]==1){
                dfs(nrow,ncol,land,visited);
            }
        }
    }
}