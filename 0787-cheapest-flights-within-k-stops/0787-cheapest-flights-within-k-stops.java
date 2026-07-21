class Solution {
    class pair{
        int node;
        int dist;
        int k;
        public pair(int node,int dist,int k){
            this.node=node;
            this.dist=dist;
            this.k=k;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];

            list.get(u).add(new int[]{v,w});
        }

        int dist[][] = new int[n][k+1];

        for(int d[]:dist){
            Arrays.fill(d,(int)1e9);
        }

        PriorityQueue<pair> pq =new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.offer(new pair(src,0,0));
        dist[src][0] = 0;

        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int node=curr.node;
            int d=curr.dist;
            int stop=curr.k;

            for(int arr[]:list.get(node)){
                int neigh=arr[0];
                int cost=arr[1];

                if(neigh==dst && dist[neigh][stop]>d+cost){
                  dist[neigh][stop]=d+cost;  
                }
                else if(stop+1<=k && dist[neigh][stop+1]>d+cost){
                    pq.offer(new pair(neigh,d+cost,stop+1));
                    dist[neigh][stop+1]=d+cost;
                }
            }
        }

        int ans=(int)1e9;


        for(int j=0;j<dist[dst].length;j++){
            ans=Math.min(ans,dist[dst][j]);
        }

        return (ans==(int)1e9)?-1:ans;
    }
}