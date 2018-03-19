import java.util.Scanner;

public class Main {

	static int[] memo;
	static char[] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//char[] arr = null;
		memo = new int[10000];
		arr = new char[10000];
		
		int cases = scan.nextInt();
		int res = 0;
		
		while(cases-- > 0) {
			int idx = 0;
			
			String str = scan.next();
			arr = str.toCharArray();
			memo = new int[arr.length];
			res = solve(arr.length-1);
			System.out.println(res);
			
		}
		
		scan.close();
		
	}

	private static int solve(int curr) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		
		int token3 = Integer.MAX_VALUE;
		int token4 = Integer.MAX_VALUE;
		int token5 = Integer.MAX_VALUE;
		
		if(memo[curr] > 0) {
			return memo[curr];
		}
		if(curr < 2) return 0;
		else if(curr == 2) {
			token3 = calPoint3(curr-2);
		} else if(curr == 3) {
			token4 = calPoint4(curr-3);
		} else if(curr == 4) {
			token5 = calPoint5(curr-4);
		} else if(curr == 5) {
			token3 = calPoint3(curr-2) + solve(curr-3);
		} else if(curr == 6) {
			token3 = calPoint3(curr-2) + solve(curr-3);
			token4 = calPoint4(curr-3) + solve(curr-4);
		} else {
			token3 = calPoint3(curr-2) + solve(curr-3);
			token4 = calPoint4(curr-3) + solve(curr-4);
			token5 = calPoint5(curr-4) + solve(curr-5);
		}
		
		min = token3;
		if(min > token4) {
			min = token4;
		}
		if(min > token5) {
			min = token5;
		}
		
		memo[curr] = min;
		
		return min;
	}

	private static int calPoint3(int i) {
		// TODO Auto-generated method stub
		int point;
		int gap = arr[i] - arr[i+1];
		if(arr[i] == arr[i+1] && arr[i] == arr[i+2]) {
			point = 1;
		}
		else if(arr[i] - arr[i+1] == arr[i+1] - arr[i+2]) {
			if(gap == -1 || gap == 1) 
				point = 2;
			else
				point = 5;
		}
		else if(arr[i] == arr[i+2]) {
			point = 4;
		} else
			point = 10;
		
		return point;
	}
	private static int calPoint4(int i) {
		// TODO Auto-generated method stub
		int point;
		int gap = arr[i] - arr[i+1];
		if(arr[i] == arr[i+1] && arr[i] == arr[i+2] && arr[i] == arr[i+3]) {
			point = 1;
		}
		else if(arr[i] - arr[i+1] == arr[i+1] - arr[i+2] && arr[i] - arr[i+1] == arr[i+2] - arr[i+3]) {
			if(gap == -1 || gap == 1) 
				point = 2;
			else
				point = 5;
		}
		else if(arr[i] == arr[i+2] && arr[i+1] == arr[i+3]) {
			point = 4;
		} else
			point = 10;
		
		return point;
	}
		
	private static int calPoint5(int i) {
		// TODO Auto-generated method stub
		int point;
		int gap = arr[i] - arr[i+1];
		if(arr[i] == arr[i+1] && arr[i] == arr[i+2] && arr[i] == arr[i+3] && arr[i] == arr[i+4]) {
			point = 1;
		}
		else if(gap == arr[i+1] - arr[i+2] && gap == arr[i+2] - arr[i+3] && gap == arr[i+3] - arr[i+4]) {
			if(gap == -1 || gap == 1) 
				point = 2;
			else
				point = 5;
		}
		else if(arr[i] == arr[i+2] && arr[i] == arr[i+4] && arr[i+1] == arr[i+3]) {
			point = 4;
		} else
			point = 10;
		
		return point;
	}

}
