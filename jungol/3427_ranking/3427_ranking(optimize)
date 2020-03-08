class Node{
	int n;
	int next;
}

class Main {

	static int upRoot[];
	static int dwRoot[];
	static int upVisited[], dwVisited[];
	static Node upper[], lower[];
	static int cnt = 1, min, max;
	static int N, M, X;
	
	static int vertex;
	static int nEdge;
	static int start;
	
	
	static void upDfs(int x){
		for (int i = upRoot[x]; i != 0 ; i = upper[i].next){
			if (upVisited[upper[i].n] == 0){
				upVisited[upper[i].n] = 1;
				max++;
				upDfs(upper[i].n);
			}
		}
	}
	static void downDfs(int x){
		for (int i = dwRoot[x]; i != 0; i = lower[i].next){
			if (dwVisited[lower[i].n] == 0){
				dwVisited[lower[i].n] = 1;
				min++;
				downDfs(lower[i].n);
			}
		}
	}
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		upRoot = new int[100001];
		dwRoot= new int[100001];
		upVisited= new int[100001];
		dwVisited= new int[100001];
		upper = new Node[500001];
		lower = new Node[500001];
		for(int i = 1; i < 500001; i++){
			upper[i] = new Node();
			lower[i] = new Node();
		}
				
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		int a, b;
		for (int i = 0; i < M; i++)
		{
		    a = sc.nextInt();
		    b = sc.nextInt();
			upper[cnt].n = b;
			upper[cnt].next = upRoot[a];
			lower[cnt].n = a;
			lower[cnt].next = dwRoot[b];
			upRoot[a] = cnt;
			dwRoot[b] = cnt;
			cnt++;
		}
		upDfs(X);
		downDfs(X);
		
		System.out.println((min + 1) + " " + (N - max));
		  
		sc.close();
	}
}
