import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	FileInputStream in = null;
    	FileOutputStream out = null;
        in = new FileInputStream("src/problem_2_Set1.in");
        out = new FileOutputStream("src/problem_2_Set1.out");
        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osr = new OutputStreamWriter(out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osr);
                
        int cases = Integer.parseInt(br.readLine());
        int[] firstX = new int[100000];
        int[] firstY = new int[100000];
        int[] secondX_E = new int[100000];
        int[] secondY_E = new int[100000];
        int[] secondX_S = new int[100000];
        int[] secondY_S = new int[100000];
        int[] secondX_W = new int[100000];
        int[] secondY_W = new int[100000];
        int[] secondX_N = new int[100000];
        int[] secondY_N = new int[100000];
        
        int total = cases;
        int nEdge;
        String[] token;
        int firstMinPoint;
        int secondEMinPoint;
        int secondSMinPoint;
        int secondWMinPoint;
        int secondNMinPoint;
        char nextDir;
        boolean result;
        boolean resultN1;
        boolean resultN2;
        boolean resultE1;
        boolean resultE2;
        boolean resultS1;
        boolean resultS2;
        boolean resultW1;
        boolean resultW2;
        
        while(cases-- > 0) {
            firstX = new int[100000];
            firstY = new int[100000];
            secondX_E = new int[100000];
            secondY_E = new int[100000];
            secondX_S = new int[100000];
            secondY_S = new int[100000];
            secondX_W = new int[100000];
            secondY_W = new int[100000];
            secondX_N = new int[100000];
            secondY_N = new int[100000];
            
        	nEdge = Integer.parseInt(br.readLine());
        	token = br.readLine().split(" ");
        	nextDir = 'N';
        	firstMinPoint = makePolygon(token, firstX, firstY, nextDir, nEdge);

        	token = br.readLine().split(" ");
        	nextDir = 'N';
        	secondNMinPoint = makePolygon(token, secondX_N, secondY_N, nextDir, nEdge);
        	nextDir = 'E';
        	secondEMinPoint = makePolygon(token, secondX_E, secondY_E, nextDir, nEdge);
        	nextDir = 'S';
        	secondSMinPoint = makePolygon(token, secondX_S, secondY_S, nextDir, nEdge);
        	nextDir = 'W';
        	secondWMinPoint = makePolygon(token, secondX_W, secondY_W, nextDir, nEdge);
        	result = true;
        	
        	resultN1 = comparePolygon1(firstX, firstY, secondX_N, secondY_N, firstMinPoint, secondNMinPoint, nEdge);
        	resultN2 = comparePolygon2(firstX, firstY, secondX_N, secondY_N, firstMinPoint, secondNMinPoint, nEdge);
        	resultE1 = comparePolygon1(firstX, firstY, secondX_E, secondY_E, firstMinPoint, secondEMinPoint, nEdge);
        	resultE2 = comparePolygon2(firstX, firstY, secondX_E, secondY_E, firstMinPoint, secondEMinPoint, nEdge);
        	resultS1 = comparePolygon1(firstX, firstY, secondX_S, secondY_S, firstMinPoint, secondSMinPoint, nEdge);
        	resultS2 = comparePolygon2(firstX, firstY, secondX_S, secondY_S, firstMinPoint, secondSMinPoint, nEdge);
        	resultW1 = comparePolygon1(firstX, firstY, secondX_W, secondY_W, firstMinPoint, secondWMinPoint, nEdge);
        	resultW2 = comparePolygon2(firstX, firstY, secondX_W, secondY_W, firstMinPoint, secondWMinPoint, nEdge);
        	
        	
        	
        	result = resultN1 || resultN2 || resultE1 || resultE2 || resultS1 || resultS2 || resultW1 || resultW2;
        	bw.write(String.valueOf(result));
            bw.newLine();
            System.out.println("case" + "" + " : " + (total-cases));
            System.out.println("nEdge" + "" + " : " +nEdge);
            System.out.println("resultN1" + "" + " : " +resultN1);
            System.out.println("resultN2" + "" + " : " +resultN2);
            System.out.println("resultE1" + "" + " : " +resultE1);
            System.out.println("resultE2" + "" + " : " +resultE2);
            System.out.println("resultS1" + "" + " : " +resultS1);
            System.out.println("resultS2" + "" + " : " +resultS2);
            System.out.println("resultW1" + "" + " : " +resultW1);
            System.out.println("resultW2" + "" + " : " +resultW2);
            System.out.println("---------------------------------");
        }
        bw.close();
    }

	private static boolean comparePolygon1(int[] firstX, int[] firstY, int[] secondX, int[] secondY, int firstMinPoint, int secondMinPoint, int nEdge) {
		// TODO Auto-generated method stub
		int deltaX = firstX[firstMinPoint] - secondX[secondMinPoint];
		int deltaY = firstY[firstMinPoint] - secondY[secondMinPoint];
		int first;
		int second;
		boolean result = true;
		for(int i = 0; i < nEdge; i++){
			first = (firstMinPoint+i) % nEdge;
			second = (secondMinPoint+i) % nEdge;
			if(firstX[first] - secondX[second] != deltaX || firstY[first] - secondY[second] != deltaY) result = false;
		}
		return result;
	}

	private static boolean comparePolygon2(int[] firstX, int[] firstY, int[] secondX, int[] secondY, int firstMinPoint, int secondMinPoint, int nEdge) {
		// TODO Auto-generated method stub
		int deltaX = firstX[firstMinPoint] - secondX[secondMinPoint];
		int deltaY = firstY[firstMinPoint] - secondY[secondMinPoint];
		int first;
		int second;
		boolean result = true;
		for(int i = 0; i < nEdge; i++){
			first = (firstMinPoint+i) % nEdge;
			second = (secondMinPoint-i) >= 0 ? (secondMinPoint-i) % nEdge : nEdge - (i-secondMinPoint);
			if(firstX[first] - secondX[second] != deltaX || firstY[first] - secondY[second] != deltaY) result = false;
		}
		return result;
	}


	private static int makePolygon(String[] token, int[] firstX, int[] firstY, char nextDir, int nEdge) {
		// TODO Auto-generated method stub
		int minPoint = 0;
		int minX = 9999999;
		int minY = 9999999;
		int key = Integer.parseInt(token[0]);
    	
		switch(nextDir){
		case 'E':
        	firstX[0] = Math.abs(key);
        	firstY[0] = 0;
        	break;
		case 'S':
        	firstX[0] = 0;
        	firstY[0] = -Math.abs(key);
        	break;
		case 'W':
        	firstX[0] = -Math.abs(key);
        	firstY[0] = 0;
        	break;
		case 'N':
        	firstX[0] = 0;
        	firstY[0] = Math.abs(key);
        	break;
		}
		minX = firstX[0];
		minY = firstY[0];
		minPoint = 0;
    	nextDir = getDirection(nextDir, key);

    	for(int i = 1; i < nEdge; i++){
    		key = Integer.parseInt(token[i]);
    		switch(nextDir){
    		case 'E':
            	firstX[i] = firstX[i-1] + Math.abs(key);
            	firstY[i] = firstY[i-1];
            	break;
    		case 'S':
            	firstX[i] = firstX[i-1];
            	firstY[i] = firstY[i-1] - Math.abs(key);
            	break;
    		case 'W':
            	firstX[i] = firstX[i-1] - Math.abs(key);
            	firstY[i] = firstY[i-1];
            	break;
    		case 'N':
            	firstX[i] = firstX[i-1];
            	firstY[i] = firstY[i-1] + Math.abs(key);
            	break;
    		}
        	nextDir = getDirection(nextDir, key);
        	if(firstX[i] < minX || firstX[i] <= minX && firstY[i] < minY ) {
        		minX = firstX[i];
        		minY = firstY[i];
        		minPoint = i;
        	}
    	}
    	return minPoint;
	}

	private static char getDirection(char nextDir, int key) {
		switch(nextDir){
		case 'E':
        	if(key>0) nextDir = 'N';
        	else nextDir = 'S';
        	break;
		case 'S':
        	if(key>0) nextDir = 'E';
        	else nextDir = 'W';
        	break;
		case 'W':
        	if(key>0) nextDir = 'S';
        	else nextDir = 'N';
        	break;
		case 'N':
        	if(key>0) nextDir = 'W';
        	else nextDir = 'E';
        	break;
		}
		return nextDir;
	}
}
