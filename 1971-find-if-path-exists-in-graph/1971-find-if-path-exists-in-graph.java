class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[]=new boolean[n];

        return helper(adj,source,destination,visited);
    }

    boolean helper(List<List<Integer>> adj,int src,int dst,boolean visited[]){

        visited[src]=true;

        if(src==dst) return true;

        for(int neigh:adj.get(src)){
            if(src==dst) return true;

            if(!visited[neigh]){
                if(helper(adj,neigh,dst,visited)){
                    return true;
                }
            }
        }

        return false;
    }
}