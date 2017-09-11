/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	static int map[][][];
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int m = scan.nextInt();
		int n = scan.nextInt();
		int h = scan.nextInt();
		map = new int[h][n][m];
		boolean ini = true;
		
		for(int k=0; k<h; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					map[k][i][j] = scan.nextInt();
					//System.out.println(k+", " +i+", " +j + " = " + map[k][i][j]);
					if(map[k][i][j] != 0) ini = false;
				}
			}
		}
		
		int cnt = 2;
		boolean ing = true;
		boolean all = true;
		while(ing){
			all = true;
			ing = false;
			for(int k=0; k<h; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++){
							System.out.println(k+", " +i+", " +j + " = " + map[k][i][j]);
						if(k-1>=0 && map[k][i][j] == 0 && map[k-1][i][j] > 0 && map[k-1][i][j] < cnt){
							map[k][i][j] = cnt;
							ing = true;
							System.out.println(k+", " +i+", " +j);
						}
						if(i-1>=0 && map[k][i][j] == 0 && map[k][i-1][j] > 0 && map[k][i-1][j] < cnt){
							map[k][i][j] = cnt;
							ing = true;
							System.out.println(k+", " +i+", " +j);
						}
						if(j-1>=0 && map[k][i][j] == 0 && map[k][i][j-1] > 0 && map[k][i][j-1] < cnt){
							map[k][i][j] = cnt;
							ing = true;
							System.out.println(k+", " +i+", " +j);
						}
						if(map[k][i][j] == 0) all = false;
					}
				}
			}
			if(ing) cnt++;
		}
		if(all == false){
			System.out.println(-1);
		} else if(ini == true){
			System.out.println(0);
		}
		
		System.out.println(cnt);
	}
}
