import java.util.*;
import java.util.Scanner;

public class Main {
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int max = 100000;
		int memo[] = new int[max+1];
		int older = scan.nextInt();
		int younger = scan.nextInt();

		for(int i = 0; i < max+1; i++) memo[i] = Integer.MAX_VALUE;

		int target;
		memo[older] = 0;
		q.add(older);
		while(true) {
			if(q.isEmpty()) break;
			target = q.poll();
			if(target-1 >= 0 && memo[target-1] > memo[target]+1) {
				memo[target-1] = memo[target]+1;
				q.add(target-1);
			}
			if(target+1 <= max && memo[target+1] > memo[target]+1) {
				memo[target+1] = memo[target]+1;
				q.add(target+1);
			}
			if(target*2 <= max && memo[target*2] > memo[target]+1) {
				memo[target*2] = memo[target]+1;
				q.add(target*2);
			}
		}
		System.out.println(memo[younger]);
		scan.close();
	}
}
