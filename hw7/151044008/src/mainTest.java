import java.util.Vector;

public class mainTest {
    public static void main(String[] args) {

        ListGraph graph=new ListGraph(10,true);
        ListGraph graph2=new ListGraph(15,false);
        MatrixGraph graph3=new MatrixGraph(10,false);
        GraphOperation op =new GraphOperation();
        Vector<Integer> path=new Vector<>();
        buildGraphforQ1(graph);
        buildGraphForQ2(graph2);
        buildGraphForQ3(graph3);
        System.out.println("*********************For Q1**************************");
        op.Plot_Graph(graph);
        System.out.println();
        System.out.println("İs Undirected: "+ op.Is_Undirected(graph));
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("The shortest distance between 9 and 1:");
        op.Shortest_Path(graph,9,1);
        System.out.println(op.getDistance());
        System.out.println();
        System.out.println("The shortest path beetween 9 and 1:");
        path=op.Shortest_Path(graph,9,1);
        for(int i=0;i<path.size();++i){
            System.out.println("***"+ path.get(i));
        }
        System.out.println("--------------------------------------");
        System.out.println("The shortest distance between 9 and 2:");
        op.Shortest_Path(graph,9,2);
        System.out.println(op.getDistance());
        System.out.println();
        System.out.println("The shortest path beetween 9 and 2:");
        path=op.Shortest_Path(graph,9,2);
        for(int i=0;i<path.size();++i){
            System.out.println("***"+ path.get(i));
        }
        System.out.println("--------------------------------------");
        System.out.println("The shortest distance between 9 and 0:");
        op.Shortest_Path(graph,9,0);
        System.out.println(op.getDistance());
        System.out.println();
        System.out.println("The shortest path beetween 9 and 0:");
        path=op.Shortest_Path(graph,9,0);
        for(int i=0;i<path.size();++i){
            System.out.println("***"+ path.get(i));
        }
        System.out.println();

        System.out.println("*********************For Q2**************************");
        op.Plot_Graph(graph2);
        System.out.println();
        System.out.println("İs Undirected: "+ op.Is_Undirected(graph2));
        System.out.println();
        System.out.println("9 and 6 are Connected: " + op.Is_Connected(graph2,9,6));
        System.out.println("14 and 13 are Connected: " + op.Is_Connected(graph2,14,13));
        System.out.println("13 and 14 are Connected: " + op.Is_Connected(graph2,13,14));
        System.out.println("3 and 1 are Connected: " + op.Is_Connected(graph2,3,1));
        System.out.println("10 and 4 are Connected: " + op.Is_Connected(graph2,10,4));
        System.out.println();
        System.out.println("*********************For Q3**************************");
        System.out.println();
        op.Plot_Graph(graph3);
        System.out.println();
        System.out.println("İs Undirected: "+ op.Is_Undirected(graph3));
        System.out.println("*****************************************************");

    }

    public static void buildGraphforQ1(Graph graph){

        Edge edge=new Edge(9,8,10.0);
        Edge edge1=new Edge(8,7,15.0);
        Edge edge2=new Edge(7,6,20.0);
        Edge edge3=new Edge(6,5,5.0);
        Edge edge4=new Edge(5,4,5.0);
        Edge edge5=new Edge(4,3,10.0);
        Edge edge6=new Edge(3,2,25.0);
        Edge edge7=new Edge(2,1,15.0);
        Edge edge8=new Edge(1,0,30.0);
        Edge edge9=new Edge(5,0,5.0);
        Edge edge10=new Edge(6,1,10.0);
        Edge edge11=new Edge(6,2,2.0);
        Edge edge12=new Edge(7,2,20.0);
        Edge edge13=new Edge(7,3,40.0);
        Edge edge14=new Edge(8,3,15.0);
        Edge edge15=new Edge(8,4,35.0);
        Edge edge17=new Edge(5,1,45.0);
        Edge edge18=new Edge(9,7,15.0);
        Edge edge19=new Edge(9,6,25.0);
        Edge edge20=new Edge(9,4,10.0);
        graph.insert(edge);
        graph.insert(edge1);
        graph.insert(edge2);
        graph.insert(edge3);
        graph.insert(edge4);
        graph.insert(edge5);
        graph.insert(edge6);
        graph.insert(edge7);
        graph.insert(edge8);
        graph.insert(edge9);
        graph.insert(edge10);
        graph.insert(edge11);
        graph.insert(edge12);
        graph.insert(edge13);
        graph.insert(edge14);
        graph.insert(edge15);
        graph.insert(edge17);
        graph.insert(edge18);
        graph.insert(edge19);
        graph.insert(edge20);


    }

    public static void buildGraphForQ2(Graph graph){
        Edge edge=new Edge(0,5);
        Edge edge1=new Edge(0,10);
        Edge edge2=new Edge(10,11);
        Edge edge3=new Edge(11,7);
        Edge edge4=new Edge(7,12);
        Edge edge5=new Edge(7,8);
        Edge edge6=new Edge(8,3);
        Edge edge7=new Edge(3,1);
        Edge edge8=new Edge(2,1);
        Edge edge9=new Edge(1,6);
        Edge edge10=new Edge(13,14);
        Edge edge11=new Edge(13,9);
        Edge edge12=new Edge(9,4);
        graph.insert(edge);
        graph.insert(edge1);
        graph.insert(edge2);
        graph.insert(edge3);
        graph.insert(edge4);
        graph.insert(edge5);
        graph.insert(edge6);
        graph.insert(edge7);
        graph.insert(edge8);
        graph.insert(edge9);
        graph.insert(edge10);
        graph.insert(edge11);
        graph.insert(edge12);
    }
    public static void buildGraphForQ3(Graph graph){
        Edge edge=new Edge(0,5);
        Edge edge1=new Edge(0,1);
        Edge edge2=new Edge(1,6);
        Edge edge3=new Edge(1,2);
        Edge edge4=new Edge(2,7);
        Edge edge5=new Edge(2,3);
        Edge edge6=new Edge(3,8);
        Edge edge7=new Edge(3,4);
        Edge edge8=new Edge(4,9);
        Edge edge9=new Edge(5,6);
        Edge edge10=new Edge(6,7);
        Edge edge11=new Edge(7,8);
        Edge edge12=new Edge(8,9);
        graph.insert(edge);
        graph.insert(edge1);
        graph.insert(edge2);
        graph.insert(edge3);
        graph.insert(edge4);
        graph.insert(edge5);
        graph.insert(edge6);
        graph.insert(edge7);
        graph.insert(edge8);
        graph.insert(edge9);
        graph.insert(edge10);
        graph.insert(edge11);
        graph.insert(edge12);

    }
}
