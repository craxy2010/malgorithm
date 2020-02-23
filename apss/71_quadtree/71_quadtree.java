import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    static String[] token;
    static int nDay;
    static int nTeam;
	static int[] cost;
	static double minAvg = 100.0;
	static double sum;
    
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        cost = new int[1000];
        
        int cases = Integer.parseInt(sc.nextLine());
        
        while(cases-- > 0) {
        	token = sc.nextLine().split(" ");
            nDay = Integer.parseInt(token[0]);
            nTeam = Integer.parseInt(token[1]);
            
        	token = sc.nextLine().split(" ");
            for(int n = 0; n < nDay; n++) cost[n] = Integer.parseInt(token[n]);
            
            for(int rday = nTeam; rday <= nDay; rday++){
	            for(int i = 0; i <= nDay-rday ; i++) {
	            	sum = 0.0;
	            	for(int j = i; j < i+rday; j++){
	            		sum += cost[j];
	            	}
	            	if(sum/(double)rday < minAvg) minAvg = sum/(double)rday;
	            }
            }
            
            System.out.printf("%.12f", minAvg);
            System.out.println();
        }
    }
}
