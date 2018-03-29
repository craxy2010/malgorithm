import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int data[] = new int[n];

		for(int i = 0; i < n; i++) 
			data[i] = sc.nextInt();
		
		int sum, cnt = 0;
		for(int i = 0; i < n; i++) {
			sum = 0;
			for(int j = i; j < n; j++) {
				sum += data[j];
				if(sum == m) cnt++;
				if(sum >= m) break;
			}
		}
		System.out.println(cnt);
	}
}
