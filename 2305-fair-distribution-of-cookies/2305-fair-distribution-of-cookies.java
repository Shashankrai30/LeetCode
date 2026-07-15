class Solution {
    int ans;
    int child[];
    public int distributeCookies(int[] cookies, int k) {

        ans=Integer.MAX_VALUE;
        child = new int[k];

        dfs(0,cookies);
        return ans;
    }

    void dfs(int ind,int cookies[]){

        if(ind==cookies.length){
            int temp=0;
            for(int i=0;i<child.length;i++){
               temp=Math.max(temp,child[i]);
            }
            ans=Math.min(ans,temp);
            return;
        }

        for(int k=0;k<child.length;k++){

            child[k]+=cookies[ind];
            dfs(ind+1,cookies);
            child[k]-=cookies[ind];
        }
    }
}