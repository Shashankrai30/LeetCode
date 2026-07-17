class Solution {
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    int rowl;
    int coll;
    boolean pacific;
    boolean atlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       rowl=heights.length;
       coll=heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

       for(int i=0;i<rowl;i++){
        for(int j=0;j<coll;j++){
            boolean visited[][] = new boolean[rowl][coll];

            pacific=false;
            atlantic=false;

            dfs(i,j,visited,heights);

            if(pacific && atlantic){
                List<Integer> temp =new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
            }
        }
       }

       return ans;
    }

    void dfs(int row,int col,boolean visited[][],int height[][]){

        visited[row][col] = true;
        if(row==rowl-1 || col==coll-1){
            atlantic=true;
        }
        if(row==0 || col==0){
            pacific=true;
        }


        for(int i=0;i<4;i++){

            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && !visited[nrow][ncol] && height[nrow][ncol]<=height[row][col]){
                dfs(nrow,ncol,visited,height);
            }
        }
    }
}