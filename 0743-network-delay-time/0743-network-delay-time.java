class Solution {
    class pair{
        int node;
        int dist;
        public pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<pair>> list = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];

            list.get(u).add(new pair(v,w));
        }

        int distance[] = new int[n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new pair(k,0));
        distance[k]=0;

        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int node = curr.node;
            int dist=curr.dist;

            for(pair temp:list.get(node)){
                int neigh=temp.node;
                int d=temp.dist;

                if(dist+d<distance[neigh]){
                    pq.offer(new pair(neigh,dist+d));
                    distance[neigh]=dist+d;
                }
            }
        }

        int ans=0;

        for(int i=1;i<n+1;i++){
            ans=Math.max(ans,distance[i]);
        }

        return(ans==Integer.MAX_VALUE)?-1:ans;

    }
}