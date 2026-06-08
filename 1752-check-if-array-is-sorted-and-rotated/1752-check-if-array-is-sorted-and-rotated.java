class Solution {
    public boolean check(int[] arr) {
       int i=0;
       int j=arr.length-1;
       int n=arr.length;

       int rotated=0;

       while(i<=j){
        int mid=i+(j-i)/2;

        if(arr[mid]>=arr[0] && arr[mid]>arr[(n+mid+1)%n]){
            rotated=mid;
            break;
        }
        else if(arr[mid]>=arr[0] && arr[mid]<=arr[(n+mid+1)%n]){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
       } 

       for(int ind=0;ind<rotated;ind++){
        if(arr[ind]>arr[ind+1]) return false;
       }

       for(int ind=rotated+1;ind<n;ind++){
        if(arr[ind]>arr[(ind+1+n)%n]) return false;
       }

       return true;
    }
}