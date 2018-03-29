import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int year[] = new int[n];
		int rainfall[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			year[i] = sc.nextInt();
			rainfall[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int x[] = new int[m]; 
		int y[] = new int[m];
		for(int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int startYear, endYear, startRainFall, endRainFall;
		boolean hasNoDataYear, cmpResult;
		String result;
		
		for(int k = 0; k < m; k++) {
			startYear = x[k];
			endYear = y[k];
			hasNoDataYear = false;
			cmpResult = true;
			startRainFall = 0;
			endRainFall = 0;
			
			for(int i = 0; i < n; i++) {
				if(year[i] == startYear) startRainFall = rainfall[i];
				if(year[i] == endYear) endRainFall = rainfall[i];
			}

			if(startRainFall == 0 || endRainFall == 0) hasNoDataYear = true;
			
			for(int i = 0; i < n; i++) {
				if(year[i] < startYear || year[i] > endYear) continue;
				if(i+1 < n && year[i+1] - year[i] != 1) hasNoDataYear = true;
				if(year[i] > startYear && endRainFall > 0 && rainfall[i] > endRainFall) cmpResult = false;
			}
			if(cmpResult && !hasNoDataYear && startRainFall >= endRainFall) {
				result = "true";
			} else if(cmpResult && hasNoDataYear) {
				result = "maybe";
			} else {
				result = "false";
			}
			System.out.println(result);
		}
	}
}
