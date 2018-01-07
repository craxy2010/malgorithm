import java.util.*;
 
public class Main{
 
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
 
		int n = scan.nextInt();
 
		while(n-->0){
			int sum = 0;
			int set = scan.nextInt();
			int[] kaist = new int[set];
			int[] postech = new int[set];
			for(int i=0; i<set; i++) kaist[i] = scan.nextInt();
			for(int i=0; i<set; i++) postech[i] = scan.nextInt();
			Arrays.sort(kaist);
			Arrays.sort(postech);
			//int j = set-1;
			for(int i=set-1, j = set-1; i>=0; i--, j--){
				while(j>=0 && kaist[i] <= postech[j]) j--;
				if(j<0) break;
 
				System.out.println(kaist[i] + " " + postech[j]);
				sum += kaist[i];
			}
			System.out.println(sum);
		}
	}
}
