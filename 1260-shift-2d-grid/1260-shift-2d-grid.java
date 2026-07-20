class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
       
       int rowl=grid.length;
       int coll=grid[0].length;

       int temp[][] = new int[rowl][coll];

        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                int idx = i * coll + j;
                int newIdx = (idx + k) % (rowl * coll);

                int newRow = newIdx / coll;
                int newCol = newIdx % coll;
                temp[newRow][newCol]=grid[i][j];
            }
        }

       List<List<Integer>> ans = new ArrayList<>();

       for(int i=0;i<rowl;i++){
        ans.add(new ArrayList<>());
       }

       for(int i=0;i<rowl;i++){
        for(int j=0;j<coll;j++){
            ans.get(i).add(temp[i][j]);
        }
       }

       return ans;

    }
}