import java.util.Scanner;

public class Main {

	public static boolean fixed[];
	public static boolean used[];
	public static int nSeat;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		nSeat = sc.nextInt();
		fixed = new boolean[nSeat+1];
		used = new boolean[nSeat+1];
		int nFixed = sc.nextInt();
		
		for(int i = 0; i < nFixed; i++) {
			fixed[sc.nextInt()] = true;
		}
		
		int result = 0;
		if(fixed[1] || fixed[2]) {
			result = solve(1, 1);
		} else {
			result = solve(1, 1) + solve(1, 2);
		}
		
		System.out.println(result);
	}

	private static int solve(int i, int value) {
		// TODO Auto-generated method stub
		if(i == nSeat) return 1;
		
		used[value] = true;
		
		int result = 0;
		if(!used[i] && used[i+1]) {
			result = solve(i+1, i);;
		} else if(i+1 <= nSeat && fixed[i+1] || i+2 <= nSeat && fixed[i+2] ) {
			result = solve(i+1, i+1);
		} else {
			if(!used[i]) result += solve(i+1, i);
			if(i+1 <= nSeat && !used[i+1]) result += solve(i+1, i+1);
			if(i+2 <= nSeat && !used[i+2]) result += solve(i+1, i+2);
		}
		
		used[value] = false;
		
		return result;
	}
}
