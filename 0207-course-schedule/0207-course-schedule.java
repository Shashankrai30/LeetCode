class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            list.get(v).add(u);
        }

        boolean vis[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(i,vis,path,list)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int node,boolean vis[],boolean path[],ArrayList<ArrayList<Integer>> list){
        vis[node]=true;
        path[node]=true;

        for(int neigh:list.get(node)){
            if(!vis[neigh]){
                if(!dfs(neigh,vis,path,list)) return false;
            }
            else{
                if(path[neigh]) return false;
            }
        }

        path[node] = false;

        return true;
    }

}