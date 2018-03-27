import java.util.Scanner;

public class Main {
	
	public static int map[][];
	public static int minPoint[][];
	public static int maxPoint[][];
	public static int nLine;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		nLine = sc.nextInt();
		map = new int[nLine][3];
		minPoint = new int[nLine][3];
		maxPoint = new int[nLine][3];
		
		for(int i = 0; i < nLine; i++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int max, min;
		solve(0, 0);
		solve(0, 1);
		solve(0, 2);
		max = maxPoint[0][0] > maxPoint[0][1] ? (maxPoint[0][0] > maxPoint[0][2] ? maxPoint[0][0] : maxPoint[0][2]) : (maxPoint[0][1] > maxPoint[0][2] ? maxPoint[0][1] : maxPoint[0][2]);
		min = minPoint[0][0] < minPoint[0][1] ? (minPoint[0][0] < minPoint[0][2] ? minPoint[0][0] : minPoint[0][2]) : (minPoint[0][1] < minPoint[0][2] ? minPoint[0][1] : minPoint[0][2]);
		
		System.out.println(max + " " + min);
	}
	
	private static void solve(int i, int j) {
		// TODO Auto-generated method stub
		if(i == nLine-1) {
			maxPoint[i][j] = map[i][j];
			minPoint[i][j] = map[i][j];
			return;
		}
		if(maxPoint[i][j] > 0 || minPoint[i][j] > 0) return;
		
		if(j == 0) {
			solve(i+1, 0);
			solve(i+1, 1);
			maxPoint[i][j] = maxPoint[i+1][0] > maxPoint[i+1][1] ? maxPoint[i+1][0]: maxPoint[i+1][1];
			minPoint[i][j] = minPoint[i+1][0] < minPoint[i+1][1] ? minPoint[i+1][0]: minPoint[i+1][1];	
		} else if(j == 1) {
			solve(i+1, 0);
			solve(i+1, 1);
			solve(i+1, 2);
			maxPoint[i][j] = maxPoint[i+1][0] > maxPoint[i+1][1] ? (maxPoint[i+1][0] > maxPoint[i+1][2] ? maxPoint[i+1][0] : maxPoint[i+1][2]) : (maxPoint[i+1][1] > maxPoint[i+1][2] ? maxPoint[i+1][1] : maxPoint[i+1][2]);
			minPoint[i][j] = minPoint[i+1][0] < minPoint[i+1][1] ? (minPoint[i+1][0] < minPoint[i+1][2] ? minPoint[i+1][0] : minPoint[i+1][2]) : (minPoint[i+1][1] < minPoint[i+1][2] ? minPoint[i+1][1] : minPoint[i+1][2]);
			
		} else if(j == 2) {
			solve(i+1, 1);
			solve(i+1, 2);
			maxPoint[i][j] = maxPoint[i+1][1] > maxPoint[i+1][2] ? maxPoint[i+1][1]: maxPoint[i+1][2];
			minPoint[i][j] = minPoint[i+1][1] < minPoint[i+1][2] ? minPoint[i+1][1]: minPoint[i+1][2];	
		}
		maxPoint[i][j] += map[i][j];
		minPoint[i][j] += map[i][j];
		return;
	}
}
