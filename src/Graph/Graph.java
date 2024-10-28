package Graph;

import java.util.*;

public class Graph {

    int V;
    List[] adjList;

    Graph(int v) {
        this.V = v;
        this.adjList = new LinkedList[v];
        for(int i=0; i<V; ++i) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u, int v, boolean directed) {
        this.adjList[u].add(v);
        if(!directed) {
            adjList[v].add(u);
        }
    }

    void BFSForDirected(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];
        q.add(v);
        int[] dist = new int[V];
        dist[v] = 0;
        int[] source = new int[V];
        visited[v] = true;
        source[v] = v;
        while(!q.isEmpty()) {
            int u = q.remove();
            System.out.print(u + " ");
            Iterator<Integer> it = adjList[u].iterator();
            while(it.hasNext()) {
                int nbr = it.next();
                if(!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                    dist[nbr] = 1 + dist[u];
                    source[nbr] = u;
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(dist));
    }

    void BFS(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];
        q.add(v);
        int[] dist = new int[V];
        dist[v] = 0;
        int[] source = new int[V];
        visited[v] = true;
        source[v] = v;
        while(!q.isEmpty()) {
            int u = q.remove();
            System.out.print(u + " ");
            Iterator<Integer> it = adjList[u].iterator();
            while(it.hasNext()) {
                int nbr = it.next();
                if(!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                    dist[nbr] = 1 + dist[u];
                    source[nbr] = u;
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(dist));
        System.out.println("Shortest path as follows:");
        for(int i=0; i<V; ++i) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(i);
            int curr = i;
            while(source[curr] != v) {
                path.add(source[curr]);
                curr = source[curr];
            }
            path.add(v);
            int n = path.size();
            for(int j=0; j<n/2; ++j) {
                int temp = path.get(j);
                path.set(j, path.get(n-1-j));
                path.set(n-1-j, temp);
            }
            System.out.println(path);
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[this.V];
        DFShelper(v, visited);
    }

    private void DFShelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> it = adjList[v].iterator();
        while(it.hasNext()) {
            int nbr = it.next();
            if(!visited[nbr]) {
                DFShelper(nbr, visited);
            }
        }
    }


    void showAdjList(){
        Arrays.deepToString(this.adjList);
    }

    private boolean checkCycle() {
        boolean[] visited = new boolean[V];
        return checkCycleHelper(0, visited, -1);
    }

    private boolean checkCycleHelper(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> it = adjList[v].iterator();
        while(it.hasNext()) {
            int nbr = it.next();
            if(!visited[nbr]) {
                boolean cyclefound = checkCycleHelper(nbr, visited, v);
                if(cyclefound) {
                    return true;
                }
            }
            else if(nbr!=parent) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCycleDirectedHelper(int v, boolean[] visited, boolean[] ancestors) {
        visited[v] = true;
        ancestors[v] = true;
        Iterator<Integer> it = adjList[v].iterator();
        while(it.hasNext()) {
            int nbr = it.next();
            if(!visited[nbr]) {
                boolean cyclefound = checkCycleDirectedHelper(nbr, visited, ancestors);
                if(cyclefound) {
                    return true;
                }
            }
            else if(ancestors[nbr]) {
                return true;
            }
        }
        ancestors[v] = false;
        return false;
    }

    private boolean checkCycleDirected() {
        boolean[] visited = new boolean[V];
        boolean[] ancestors = new boolean[V];
        return checkCycleDirectedHelper(0, visited, ancestors);
    }


    public static void main(String[] args) {

        // Undirected graph
        int V = 6;
        Graph gr = new Graph(V);
        gr.addEdge(0,2 ,false);
        gr.addEdge(0,3 ,false);
        gr.addEdge(1,3 ,false);
        gr.addEdge(1,4 ,false);
        gr.addEdge(2,4 ,false);
        gr.addEdge(2,5 ,false);
        gr.addEdge(3,5 ,false);

        System.out.println(Arrays.deepToString(gr.adjList));

        gr.BFS(2);
        gr.DFS(2);
        System.out.println(gr.checkCycle());


        // Directed graph
        gr = new Graph(V);
        gr.addEdge(0,1 ,true);
        gr.addEdge(0,3 ,true);
        gr.addEdge(1,2 ,true);
        gr.addEdge(1,3 ,true);
        gr.addEdge(1,4 ,true);
        gr.addEdge(2,5 ,true);
        gr.addEdge(4,5 ,true);
        gr.addEdge(5,0 ,true);
        gr.BFSForDirected(1);
        gr.DFS(1);
        System.out.println(gr.checkCycleDirected());
    }
}
