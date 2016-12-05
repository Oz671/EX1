
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;





public class Graph_algo {
	public static void main(String[] args) {
		//		args=new String[2];
		//		args[0]="test_Ex1.txt";
		//		args[1]="test1_Ex1_run.java.txt";
		//		try {
		//			Graph_algo.Dijkstra1(args[0], args[1]);
		//		}
		//		catch (Exception e) {
		//			e.printStackTrace();
		//		}



	}

	public static Graph getGraph(String fileName) throws Exception{
		int numVer = 0;
		int numEdge=0;
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		numVer=Integer.parseInt(br.readLine());
		numEdge=Integer.parseInt(br.readLine());
		Graph.Edge[] t = new Graph.Edge[numEdge];
		String line =br.readLine();
		StringTokenizer st;
		int v1,v2,ind=0;
		double w;
		while (line!=null){
			st=new StringTokenizer(line);
			v1=Integer.parseInt(st.nextToken());
			v2=Integer.parseInt(st.nextToken());
			w=Double.parseDouble(st.nextToken());
			t[ind++]=new Graph.Edge(v1, v2, w);
			line=br.readLine();
		}
		br.close();
		fr.close();
		return new Graph(t,numVer);
	}
	private static void Dijkstra1(String Graph, String test) throws Exception  {
		long s = new Date().getTime();
		int numVer = 0;
		int numEdge=0;
		//graph
		System.out.println("Loading graph file: " + Graph + " runing a test " + test);
		String ans = "Solution_" + test + "_" + Graph + "_" + s + "_.txt";
		FileReader fr = new FileReader(Graph);
		BufferedReader br = new BufferedReader(fr);
		numVer=Integer.parseInt(br.readLine());
		numEdge=Integer.parseInt(br.readLine());
		Graph.Edge[] t = new Graph.Edge[numEdge];
		String line =br.readLine();
		StringTokenizer st;
		int v1,v2,ind=0;
		double w;
		while (line!=null){
			st=new StringTokenizer(line);
			v1=Integer.parseInt(st.nextToken());
			v2=Integer.parseInt(st.nextToken());
			w=Double.parseDouble(st.nextToken());
			t[ind++]=new Graph.Edge(v1, v2, w);
			line=br.readLine();
		}
		br.close();
		fr.close();
		long s1 = new Date().getTime();
		System.out.println("Done loading Graph: " + Graph + "  in " + (s1 - s) + "  ms");
		//test
		Graph g = new Graph(t,numVer);
		int numBlack=0;
		int numQue=0;
		int start=0;
		int end=0;
		fr = new FileReader(test);
		br = new BufferedReader(fr);
		long startTime=System.currentTimeMillis();
		numQue = Integer.parseInt(br.readLine());
		int[] bl;
		FileWriter fw = new FileWriter(ans);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(numQue + " regenerated by a simple SE1_EX1 solution");
		for(int i=0;i<numQue;i++){
			line = br.readLine();
			if(!line.equals("info")){
				st = new StringTokenizer(line,",");
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				numBlack = Integer.parseInt(st.nextToken());
				if(numBlack!=0){
					bl=new int[numBlack];
					for(int j=0;j<numBlack;j++){
						bl[j]=Integer.parseInt(st.nextToken());
					}

				}
				else{
					bl=new int[numBlack+1];
					bl[0]=-1;
				}

				g.dijkstra(start,bl);
				pw.print(start+" "+end+" "+numBlack+" ");
				if(numBlack>0){
					for(int l=0;l<numBlack;l++){
						pw.print(bl[l]+" ");
					}
				}
				pw.print(g.printPath(end,bl));
				pw.println();
			}
			else{
				info(g,pw,startTime);
			}
		}
		long s2 = new Date().getTime();
		System.out.println("Done computing shortest paths on Graph: " + Graph + "  in " + (s2 - s1) + "  ms");
		System.out.println("Total time: " + (s2 - s) + "  ms");
		pw.close();
		fw.close();
		br.close();
		fr.close();

	}
	public static String main2(String Graph, String test) throws Exception {
		int numVer = 0;
		int numEdge=0;
		//graph
		FileReader fr = new FileReader(Graph);
		BufferedReader br = new BufferedReader(fr);
		numVer=Integer.parseInt(br.readLine());
		numEdge=Integer.parseInt(br.readLine());
		Graph.Edge[] t = new Graph.Edge[numEdge];
		String line =br.readLine();
		StringTokenizer st;
		int v1,v2,ind=0;
		double w;
		while (line!=null){
			st=new StringTokenizer(line);
			v1=Integer.parseInt(st.nextToken());
			v2=Integer.parseInt(st.nextToken());
			w=Double.parseDouble(st.nextToken());
			t[ind++]=new Graph.Edge(v1, v2, w);
			line=br.readLine();
		}
		br.close();
		fr.close();
		//test
		Graph g = new Graph(t,numVer);
		int numBlack=0;
		int numQue=0;
		int start=0;
		int end=0;
		fr = new FileReader(test);
		br = new BufferedReader(fr);
		long startTime=System.currentTimeMillis();
		numQue = Integer.parseInt(br.readLine());
		int[] bl;
		String ans = "Solution_"+test+".txt";
		FileWriter fw = new FileWriter(ans);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(numQue + " regenerated by a simple SE1_EX1 solution");
		for(int i=0;i<numQue;i++){
			line = br.readLine();
			if(!line.equals("info")){
				st = new StringTokenizer(line,",");
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				numBlack = Integer.parseInt(st.nextToken());
				if(numBlack!=0){
					bl=new int[numBlack];
					for(int j=0;j<numBlack;j++){
						bl[j]=Integer.parseInt(st.nextToken());
					}

				}
				else{
					bl=new int[numBlack+1];
					bl[0]=-1;
				}

				g.dijkstra(start,bl);
				pw.print(start+" "+end+" "+numBlack+" ");
				if(numBlack>0){
					for(int l=0;l<numBlack;l++){
						pw.print(bl[l]+" ");
					}
				}
				pw.print(g.printPath(end,bl));
				pw.println();
			}
			else{
				info(g,pw,startTime);
			}
		}
		pw.close();
		fw.close();
		br.close();
		fr.close();
		return ans;
	}

	public static boolean checkFiles(String file1,String file2) throws Exception 
	{
		FileReader fr1 = new FileReader(file1);
		FileReader fr2 = new FileReader(file2);
		BufferedReader br1 = new BufferedReader(fr1);
		BufferedReader br2 = new BufferedReader(fr2);
		String file11 = br1.readLine();
		String file22 = br2.readLine();

		while(file11!=null && file22!=null)
		{
			if(file11.compareTo(file22)!=0)
			{
				fr1.close();
				fr2.close();
				br1.close();
				br2.close();
				return false;
			}
			file11 = br1.readLine();
			file22 = br2.readLine();
		}
		fr1.close();
		fr2.close();
		br1.close();
		br2.close();

		if(file11==null && file22==null)
			return true;
		return false;


	}
	public static double distance(Graph g,int s,int d){
		return distance(g,s,d,new int[0]);
	}
	public static double distance(Graph g,int s,int d,int bl[]){
		if(s==d){
			return 0;
		}
		if(!g.getGraph().containsKey(s)||!g.getGraph().containsKey(d)){
			return Double.POSITIVE_INFINITY;
		}
		g.dijkstra(s, bl);
		return g.getGraph().get(d).dist;
	}
	public static int[] path(Graph g,int s,int d){
		return path(g,s,d,new int[0]);
	}
	public static int[] path(Graph g,int s,int d,int bl[]){
		if(s==d){
			int p[] = {s};
			return p;
		}
		if(!g.getGraph().containsKey(s)||!g.getGraph().containsKey(d)){
			return new int[0];
		}
		g.dijkstra(s,bl);
		Graph.Vertex V =g.getGraph().get(d); 
		if(V.dist == Double.POSITIVE_INFINITY){
			return new int[0];
		}
		int path[] = new int[g.getNumVers()];
		int ind = 0;
		Graph.Vertex S =g.getGraph().get(s); 

		while(V!=S){
			path[ind++]=V.name;
			V=V.previous;
		}
		path = Arrays.copyOf(path, ind);
		int h = ind/2;
		int t;
		for(int i=0,j=ind-1;i<h;i++,j--){
			t=path[i];
			path[i]=path[j];
			path[j]=t;
		}
		return path;
	}
	public static double diameter(Graph g,int lims[]){
		lims = new int[2];
		int n=g.getNumVers();
		if(n<=1){
			return 0;
		}
		if(g.getGraph().size()!=n ){
			return Double.POSITIVE_INFINITY;
		}
		int empty[] = new int[0];
		double max=0;
		double current;
		for(int i=0;i<n;i++){
			g.dijkstra(i, empty);
			for(int j=0;j<n;j++){
				current=g.getGraph().get(j).dist;
				if(current>max){
					max=current;
					lims[0]=i;
					lims[1]=j;
				}
			}
		}
		return max;

	}
	public static double radius(Graph g){
		int lims[]=new int[2];
		double dm = diameter(g,lims);
		return radius(g,lims[1],dm);
	}
	public static double radius(Graph g,int d,double dm){
		if(dm==0){
			return 0;
		}
		if(dm==Double.POSITIVE_INFINITY){
			return Double.POSITIVE_INFINITY;
		}
		Graph.Vertex V = g.getGraph().get(d);
		Graph.Vertex C;
		double mindiff;
		double hd=dm/2;
		double diff=Double.POSITIVE_INFINITY;
		do{
			mindiff=diff;
			C=V;
			V=V.previous;
			diff=Math.abs(V.dist-hd);
		}
		while(diff<mindiff);
		return Math.min(dm-C.dist,C.dist);
	}
	public static boolean TIE(Graph g){
		if(0==g.getNumEdges()){
			return true;
		}
		int numVers = g.getNumVers();
		int empty[] = new int[0];
		Graph.Vertex U,V;
		for(int i=0;i<numVers;i++){
			if(g.getGraph().containsKey(i)){
				g.dijkstra(i,empty);
				U = g.getGraph().get(i);
				for (Entry<Graph.Vertex, Double> a :U.neighbours.entrySet()) {
					V = a.getKey();
					if(V.dist-U.dist<a.getValue()){
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void info(Graph g,PrintWriter pw,long startTime){
		int lims[] = new int[2];
		double diameter = diameter(g,lims);
		double radius = radius(g,lims[1],diameter);
		boolean tie = TIE(g);
		long endTime=System.currentTimeMillis();
		long time=endTime-startTime;
		String s = "Graph:|V|="+g.getNumVers()+",|E|="+g.getNumEdges()+",";
		if(!tie){
			s+="!";
		}
		s+="TIE, Radius: "+radius+", Diameter: "+diameter+", runtime: "+time+" ms";
		pw.println(s);
		System.out.println(s);

	}
}
