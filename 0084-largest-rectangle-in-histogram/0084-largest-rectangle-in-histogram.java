class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int ans=0;
        int n=heights.length;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<=n;i++){

            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height=heights[st.pop()];

                int weidth;

                if(st.isEmpty()){
                    weidth=i;
                }
                else{
                    weidth=i-st.peek()-1;
                }

                ans=Math.max(ans,height*weidth);

            }

            st.push(i);

        }

        return ans;
    }
}