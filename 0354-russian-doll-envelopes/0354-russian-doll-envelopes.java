class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
        if(a[0]!=b[0]) return a[0]-b[0];
        if(a[1]!=b[1]) return b[1]-a[1];
        return 0;
       });


       return lis(envelopes);
    }

    int lis(int envelopes[][] ){

      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);

      for(int curr=0;curr<envelopes.length;curr++){
        if(envelopes[curr][1]>envelopes[list.get(list.size()-1)][1]){
            list.add(curr);
        }
        else{
            list.set(helper(list,curr,envelopes),curr);
        }
      }

      return list.size();
    }

    int helper(ArrayList<Integer> list,int curr,int envelopes[][]){
        int i=0;
        int j=list.size()-1;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(envelopes[list.get(mid)][1]>=envelopes[curr][1]){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        return i;
    }
}