class Solution {
    public int candy(int[] ratings) {
        
        int pre[] = new int[ratings.length];
        int suf[] = new int[ratings.length];

        Arrays.fill(pre,1);
        Arrays.fill(suf,1);

        for(int i=1;i<pre.length;i++){
            if(ratings[i-1]<ratings[i]){
                pre[i]=pre[i-1]+1;
            }
        }

        for(int i=pre.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                suf[i]=suf[i+1]+1;
            }
           
        }

        int count=0;

        for(int i=0;i<ratings.length;i++){
            count+=Math.max(pre[i],suf[i]);
        }

        return count;

    }
}