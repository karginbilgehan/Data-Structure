import java.util.*;

public class GraphOperation {
    private double distance;//shortest path sonucunda bulunan distance'i hesaplamak icin

    public double getDistance() {
        return distance;
    }

    //verilen bir directed ve acyclic graph'in cizimini yapmali
    public void Plot_Graph(Graph graph){
        int a=1;
        for(int i=graph.getNumV()-1;i>=0;--i){
            for(int j=graph.getNumV()-1;j>=0;--j){
                if(this.Is_Undirected(graph)==false){
                    if(i>j){
                        if(graph.isEdge(i,j)==true){
                            System.out.println(i +"-----"+ graph.getEdge(i,j).getWeight() +"----->"+j);

                        }
                    }
                }
                else{
                    if(graph.isEdge(i,j)==true){

                        System.out.println(i +"-----"+"----->"+j);

                    }
                }

            }

        }
    }
    public boolean Is_Connected(Graph graph, int vertex1, int vertex2){
        if(graph.isEdge(vertex1,vertex2)==true){
            return true;
        }
        else if(graph.getEdge(vertex1,vertex2).getWeight()!=Double.POSITIVE_INFINITY){
            return true;
        }
        return false;
    }

    public boolean Is_Undirected(Graph graph){
        if(graph.isDirected()==true){
            return false;
        }
        else
            return true;
    }

    public boolean Is_Acyclic_Graph(Graph graph){
        return true;
    }
    public Vector<Integer> Shortest_Path(Graph graph,int v1,int v2){
        Vector<Integer> path=new Vector<>();
        Stack<Integer> stack=new Stack<>();

        int[] pred= new int[graph.getNumV()];
        double[] dist =new double[graph.getNumV()];

        dijkstrasAlgorithm(graph,v1,pred,dist);
        int k=pred[v2];
        distance=dist[v2];

        stack.add(v2);
        while(pred[k]!=0){
                stack.push(k);
                k=pred[k];
            }

        while(!stack.isEmpty()){
            path.add(stack.pop());
        }
        return  path;
    }
    public void dijkstrasAlgorithm(Graph graph,
                                          int start,
                                          int[] pred,
                                          double[] dist) {
        int numV = graph.getNumV();
        HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
        // Initialize V–S.
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        // Main loop
        while (vMinusS.size() != 0) {
            // Find the value u in V–S with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS.
            vMinusS.remove(u);
            // Update the distances.
            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }
    public  int[] breadthFirstSearch(Graph graph, int start) {
        Queue< Integer > theQueue = new LinkedList< Integer >();
        // Declare array parent and initialize its elements to –1.
        int[] parent = new int[graph.getNumV()];
        for (int i = 0; i < graph.getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator< Edge > itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    parent[neighbor] = current;
                }
            }
            // Finished visiting current.
        }
        return parent;
    }
}
