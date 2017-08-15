/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] sounds;
		String[] cryings = new String[100];
		String crying;
		boolean bFox;
		
		int cases = Integer.parseInt(scan.nextLine());
		
		while(cases-- > 0){
			sounds = scan.nextLine().split(" ");
			for(int i = 0; i < 100; i++){
				crying = scan.nextLine();
				if(crying.equals("what does the fox say?")) break;
				cryings[i] = crying.split(" ")[2];
			}
			for(int i = 0; i < sounds.length; i++){
				bFox = true;
				for(int j = 0; j < cryings.length; j++){
					if(sounds[i].equals(cryings[j])) bFox = false;
				}
				if(bFox) System.out.print(sounds[i] + " ");
			}
		}
	}
}
