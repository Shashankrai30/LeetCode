class Solution {
    int node;
    int edge;
    public int countCompleteComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean visited[] = new boolean[n];

        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                node=0;
                edge=0;
                helper(i,list,visited);

                if(node*(node-1)/2==edge/2){
                    count++;
                }
            }
        }

        return count;
    }

    void helper(int Node, ArrayList<ArrayList<Integer>> list,boolean visited[]){

        visited[Node]=true;
        node++;

        for(int neigh:list.get(Node)){
            edge++;

            if(!visited[neigh]){
                helper(neigh,list,visited);
            }
        }
    }
}