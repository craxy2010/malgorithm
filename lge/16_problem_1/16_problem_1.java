import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
    static int[] parentOf; 
    static int grandFather;
    static int maxDepth;
    
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	FileInputStream in = null;
    	FileOutputStream out = null;
        in = new FileInputStream("src/problem_1_Set1.in");
        out = new FileOutputStream("src/problem_1_Set0.out");
        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osr = new OutputStreamWriter(out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osr);
        
        int cases = Integer.parseInt(br.readLine());
        grandFather = 0;
        
        while(cases-- > 0) {
        	int nPerson = Integer.parseInt(br.readLine());
        	int nRelation = nPerson-1;
            String[] token;
            int person1, person2;
            parentOf = new int[nPerson+1];
            for(int i=0;i<nPerson+1;i++) parentOf[i] = 0;
            grandFather = 0;
            maxDepth = 0;
            while(nRelation-- > 0) {
                token = br.readLine().split(" ");
                person1 = Integer.parseInt(token[0]);
                person2 = Integer.parseInt(token[1]);
                parentOf[person2] = person1;
        	}
            grandFather = getGrandFather(1);
            
            int cnt;
            while(nPerson-- > 0) {
            	cnt = 0;
            	if(nPerson+1 == grandFather) continue;
            	cnt = getDepth(nPerson+1, cnt) + 1;
            	if(cnt > maxDepth){
            		maxDepth = cnt;
            	}
            }
            
            bw.write(String.valueOf(maxDepth));
            bw.newLine();
        }
        bw.close();
    }

	private static int getDepth(int person, int cnt) {
		// TODO Auto-generated method stub
		if(parentOf[person] == grandFather){
			return 1;
		} else {
			return getDepth(parentOf[person], cnt) + 1;
		}			
	}
	private static int getGrandFather(int person) {
		// TODO Auto-generated method stub
		if(parentOf[person] == 0){
			return person;
		} else {
			return getGrandFather(parentOf[person]);
		}			
	}
}
