package hackerrank_cracking_02_strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class main {

    public static int numberNeeded(String first, String second) {
    	boolean[] bFirst = new boolean[128];
    	boolean[] bSecond = new boolean[128];
    	char[] a = first.toCharArray();
    	char[] b = second.toCharArray();
    	for(char c : a) bFirst[c] = true;
    	for(char c : b) bSecond[c] = true;
    	
    	int tbdFirst = first.length();
    	int tbdSecond = first.length();
    	for(char c : a) if(bSecond[c]) tbdFirst--;
    	for(char c : b) if(bFirst[c]) tbdSecond--;
    	   	
		return tbdFirst + tbdSecond;
    }
  
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
