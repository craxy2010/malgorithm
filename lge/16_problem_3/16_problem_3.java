import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int numOfsubStr;
	static int[] numOfChar;
	static boolean[] trueOfChar;
	static char[] targetChars;
    static String[] subStr;
    static int numOfResult = 0;
    static boolean result;
    static int numOfFalse;
    
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	FileInputStream in = null;
    	FileOutputStream out = null;
        in = new FileInputStream("src/problem_3_Set2.in");
        out = new FileOutputStream("src/problem_3_Set2.out");
        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osr = new OutputStreamWriter(out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osr);
        
        int cases = Integer.parseInt(br.readLine());
        int total = cases;
        String str;
        numOfChar = new int[26];
        
        
        while(cases-- > 0) {
        	numOfResult = 0;
        	str = br.readLine();
        	numOfsubStr = str.length();
        	targetChars = new char[numOfsubStr];
        	str.getChars(0, str.length(), targetChars, 0);
        	
            System.out.println("case" + "" + " : " + (total-cases));
            System.out.println("numOfsubStr" + "" + " : " +numOfsubStr);
            
        	for(int i = 0; i<numOfsubStr; i++) {
        		for(int n = 0; n < 26; n++) numOfChar[n] = 0;
        		numOfFalse = 0;
        		for(int j = i; j<numOfsubStr; j++) {
        			addNumOfResult(i,j);
        		}        		
        	}
        	
            System.out.println("---------------------------------");
            bw.write(String.valueOf(numOfResult));
            bw.newLine();
        }
        bw.close();
    }

	private static void addNumOfResult(int i, int j) {
        int x = (int)targetChars[j] - 97;
    	numOfChar[x] =  numOfChar[x] + 1;
    	if (numOfChar[x] % 2 == 1) {
    		numOfFalse++;
    	} else {
    		numOfFalse--;
    	}
    	if(numOfFalse==0) numOfResult++; 
	}
}
