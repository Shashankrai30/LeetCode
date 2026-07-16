class Solution {
    public boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                list.get(i).add(graph[i][j]);
            }
        }

        boolean visited[] = new boolean[list.size()];
        int color[] = new int[list.size()];

        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                if(!dfs(i,list,visited,color,0)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int node,ArrayList<ArrayList<Integer>> list, boolean visited[],int color[],int col){

        visited[node] = true;
        color[node] = col;

        for(int neigh:list.get(node)){
            if(!visited[neigh]){
                if(!dfs(neigh,list,visited,color,1-col)){
                    return false;
                }
            }
            else{
                if(color[node]==color[neigh]) return false;
            }
        }
        return true;
    }
}