class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i=0;
        int j=0;
        for(int w:weights){
            j+=w;
        }

        while(i<=j){
            int mid=i+(j-i)/2;

            int cap=mid;
            int count=0;
            boolean limit=false;

            for(int w:weights){
                if(w>mid){
                    i=mid+1;
                    limit = true;
                    break;
                }
                if(cap-w>=0){
                    cap-=w;
                }
                else{
                    count++;
                    cap=mid-w;
                }
            }

            if(limit) continue;

            if(count>=days){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }

        return i;
    }
}