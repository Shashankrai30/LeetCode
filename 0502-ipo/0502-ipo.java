class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int arr[][] = new int[profits.length][2];

        for(int i=0;i<arr.length;i++){
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }

        Arrays.sort(arr,(a,b)->a[1]-b[1]);

        for(int i=0;i<arr.length;i++){
            profits[i] = arr[i][0];
            capital[i] = arr[i][1];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<profits.length;i++){

            if(capital[i]<=w){
                pq.offer(profits[i]);
            }
            else{

                while(!pq.isEmpty() && capital[i]>w){
                    w+=pq.poll();
                    k--;

                    if(k==0) return w;


                }

                if(capital[i]>w) return w;
                else{
                    pq.offer(profits[i]);
                }
            }            
        }

        while(k-->0 && !pq.isEmpty()){
            w+=pq.poll();
        }

        return w;
    }
}