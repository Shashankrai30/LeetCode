class Solution {
    int rowl;
    int coll;
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    int ans;
    public int largestIsland(int[][] grid) {

        rowl=grid.length;
        coll=grid[0].length;
        int num=2;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]==1){
                    ans=0;
                    helper(i,j,grid,num);
                    map.put(num,ans);
                    num++;
                    max=Math.max(max,ans);
                }
            }
        }

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set = new HashSet<>();
                    int temp=0;
                    for(int k=0;k<4;k++){
                        int nrow=i+dr[k];
                        int ncol=j+dc[k];

                        if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll && grid[nrow][ncol]>1){
                            if(!set.contains(grid[nrow][ncol])){
                                temp+=map.get(grid[nrow][ncol]);
                                set.add(grid[nrow][ncol]);
                            }
                        }
                    }
                    max=Math.max(max,temp+1);
                }
            }
        }

        return max;
    }

    void helper(int row,int col,int grid[][],int num){

        grid[row][col]=num;
        ans++;

        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];

            if(nrow>=0 && ncol>=0 && nrow<rowl && ncol<coll &&  grid[nrow][ncol]==1){
                helper(nrow,ncol,grid,num);
            }
        }
    }
}