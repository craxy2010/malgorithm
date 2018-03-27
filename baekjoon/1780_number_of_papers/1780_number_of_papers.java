import java.util.Scanner;

public class Main {

	public static int map[][];
	public static int cnt1, cnt2, cnt3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(0,0,n);
		System.out.println(cnt1 + "\n" + cnt2 + "\n" + cnt3);
	}

	private static void solve(int x, int y, int n) {
		// TODO Auto-generated method stub
		boolean bResult = true;
		int iResult = map[x][y];
		for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(map[i][j] != iResult) {
					bResult = false;
					break;
				}
			}
		}
		if(bResult) {
			if(iResult == -1) cnt1++;
			else if(iResult == 0) cnt2++;
			else if(iResult == 1) cnt3++;
		} else {
			solve(x,y,n/3);
			solve(x,y+n/3,n/3);
			solve(x,y+2*n/3,n/3);
			solve(x+n/3,y,n/3);
			solve(x+n/3,y+n/3,n/3);
			solve(x+n/3,y+2*n/3,n/3);
			solve(x+2*n/3,y,n/3);
			solve(x+2*n/3,y+n/3,n/3);
			solve(x+2*n/3,y+2*n/3,n/3);
		}
	}
}
