class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        } 

        for(int i=0;i<invocations.length;i++){
            int u=invocations[i][0];
            int v=invocations[i][1];

            list.get(u).add(v);
        }

        boolean visited[] = new boolean[n];

        helper(k,list,visited);

        // boolean vis[] = new boolean[n];

        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
        //         helper(i,list,vis);
        //     }
        // }
        boolean invoke=false;
        for(int i=0;i<invocations.length;i++){
            int u=invocations[i][0];
            int v=invocations[i][1];

            if(!visited[u] && visited[v]){
                invoke=true;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(invoke){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
        }
        else{
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    ans.add(i);
                }
            }
        }



        // for(int i=0;i<n;i++){
        //     ans.add(i);
        // }

        // boolean ans = false;
        // for(int i=0;i<n;i++){
        //     if(visited[i] && vis[i]){
        //         ans.remove((Integer)i);
        //     }
        // }
        return ans;
    }

    void helper(int node,List<List<Integer>> list,boolean vis[]){

        vis[node] = true;

        for(int neigh:list.get(node)){
            if(!vis[neigh]){
                helper(neigh,list,vis);
            }
        }
    }
}