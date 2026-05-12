class Solution {
    public int candy(int[] arr) {
        int ans[]=new int[arr.length];
        
        Arrays.fill(ans,1);
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                ans[i+1]=ans[i]+1;
            }
        }
        
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]<arr[i-1] && ans[i-1]<=ans[i]){
                ans[i-1]=ans[i]+1;
            }
        }
        
        int count=0;
        for(int num:ans){
            count=count+num;
        }
        
        return count;
    }
}