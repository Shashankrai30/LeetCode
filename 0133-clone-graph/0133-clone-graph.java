/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return null;

       Node temp=new Node(node.val);

       Node vis[] = new Node[101];

       Arrays.fill(vis,null);

       dfs(temp,node,vis);

       return temp;
    }

    void dfs(Node temp,Node node,Node vis[]){
        vis[node.val]=temp;

        for(Node n:node.neighbors){
            if(vis[n.val]==null){
                
                Node copy = new Node(n.val);
                temp.neighbors.add(copy);
                dfs(copy,n,vis);
            } 
            else{
                temp.neighbors.add(vis[n.val]);
            }
        }
    }
}