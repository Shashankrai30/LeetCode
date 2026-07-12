class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int temp[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }

        Arrays.sort(temp);

        HashMap<Integer,Integer> map = new HashMap<>();

        int rank=1;

        for(int j=0;j<temp.length;j++){
            if(!map.containsKey(temp[j])){
                map.put(temp[j],rank);
                rank++;
            }
        }

        for(int i=0;i<temp.length;i++){
            arr[i]=map.get(arr[i]);
        }

        return arr;
    }

}