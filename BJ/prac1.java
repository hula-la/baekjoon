package BJ; import java.io.*; import java.util.*; 
public class prac1 { public static class Edge implements Comparable<Edge> 
{ int node; double dis; public Edge(int node, double dis) 
{ this.node = node; this.dis = dis; } @Override public int compareTo(Edge o) { return Double.compare(this.dis, o.dis); } } static int V,E, ans = 0, cnt = 0; static ArrayList<ArrayList<Edge>> graph; static boolean[] visit; static PriorityQueue<Edge> pq; public static void main(String[] args) throws Exception { BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st = new StringTokenizer(br.readLine()); pq = new PriorityQueue<>();  V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken()); visit = new boolean[V]; graph = new ArrayList<>(); for (int i = 0; i < V; i++) { graph.add(new ArrayList<>()); } for (int i = 0; i < E; i++) { st = new StringTokenizer(br.readLine()); int A = Integer.parseInt(st.nextToken()) -1; int B = Integer.parseInt(st.nextToken()) -1; int dis = Integer.parseInt(st.nextToken()); graph.get(A).add(new Edge(B, dis)); graph.get(B).add(new Edge(A, dis)); }  pq.add(new Edge(0,0)); while (!pq.isEmpty()) { Edge edge = pq.poll(); if(visit[edge.node]) continue; visit[edge.node] = true; ans += edge.dis; 
for (Edge next : graph.get(edge.node)) 
{ if(!visit[next.node]) 
{ pq.add(next); 
} 
} if (++cnt == V) break; } 
System.out.println(ans); } }

