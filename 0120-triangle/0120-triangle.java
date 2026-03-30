class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       Integer dp[][]=new Integer[triangle.size()+1][triangle.size()+1];

       return helper(0,0,triangle,dp); 
    }

    int helper(int row,int col,List<List<Integer>> triangle, Integer dp[][]){
        if(row==triangle.size() || col==triangle.get(row).size()) return Integer.MAX_VALUE/2;

        if(row==triangle.size()-1) return triangle.get(row).get(col);

        if(dp[row][col]!=null) return dp[row][col];

        int leftdown=triangle.get(row).get(col)+helper(row+1,col,triangle,dp);
        int rightdown=triangle.get(row).get(col)+helper(row+1,col+1,triangle,dp);

        return dp[row][col]=Math.min(leftdown,rightdown);
    }
}