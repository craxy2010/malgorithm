import java.util.*;
 
class AdjlistNode
{
    int vertex;
    AdjlistNode next;
      
    public AdjlistNode(int v)
    {
        vertex = v;
        next = null;
    }
}
  
class AdjList
{
    int num_members;
    AdjlistNode head;
    AdjlistNode tail;
      
    public AdjList()
    {
        num_members = 0;
        head = tail = null;
    }
}
 
class Graph
{     
    int num_vertices;
    AdjList []adjListArr;
    int visit[];
    int nCount;
       
    public Graph(int n)
    {
        num_vertices = n;
        adjListArr = new AdjList[n+1];
        for (int i = 1; i <= n; i++)
        {
            adjListArr[i] = new AdjList();
        }
        visit = new int[n+1];
        nCount = 0;
    }
      
    void addEdge(int src, int dest)
    {
        AdjlistNode newNode = new AdjlistNode(dest);
        if (adjListArr[src].tail != null)
        {
            adjListArr[src].tail.next = newNode;
            adjListArr[src].tail = newNode;
        }
        else
        {
            adjListArr[src].head = adjListArr[src].tail = newNode;
        }
        adjListArr[src].num_members++;
    }
     
    void depthFirstSearch(int v)
    {
        visit[v] = 1;
        AdjlistNode adjList = adjListArr[v].head;
        while (adjList != null)
        {
            if(visit[adjList.vertex] == 0) {
                nCount++;
                depthFirstSearch(adjList.vertex);
            }
            adjList = adjList.next;
        }
    }
}
      
  
class Main {
      
    static int vertex;
    static int nEdge;
    static int start;
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        vertex = sc.nextInt();
        nEdge = sc.nextInt();
        start = sc.nextInt();
         
        Graph graph_up = new Graph(vertex);
        Graph graph_down = new Graph(vertex);
        for (int i = 0; i < nEdge; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph_up.addEdge(v1, v2);
            graph_down.addEdge(v2, v1);
        }        
        graph_up.depthFirstSearch(start);
        int nUp = graph_up.nCount;
        graph_down.depthFirstSearch(start);
        int nDown = graph_down.nCount;
         
        System.out.println((nDown+1) + " " + (vertex-nUp));
  
        sc.close();
    }
}
