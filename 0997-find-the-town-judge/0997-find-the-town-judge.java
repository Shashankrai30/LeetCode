class Solution {
    public int findJudge(int n, int[][] trust) {
       int degree[] = new int[n];

       for(int i=0;i<trust.length;i++){
        degree[trust[i][1]-1]++;
        degree[trust[i][0]-1]--;
       } 

       for(int j=0;j<n;j++){
        if(degree[j]==n-1) return j+1;
       }

       return -1;
    }
}