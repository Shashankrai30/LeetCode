class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<isConnected.length;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[list.size()];
        int count=0;


        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                dfs(i,visited,list);
                count++;
            }
        }

        return count;
    }

    void dfs(int Node,boolean visited[],ArrayList<ArrayList<Integer>> list){

        visited[Node]=true;

        for(int neigh:list.get(Node)){
            if(!visited[neigh]){
                dfs(neigh,visited,list);
            }
        }
    }
}