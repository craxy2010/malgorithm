import java.io.*;
import java.util.*;

class Point {
	float x, y;
	Point(float x, float y){
		this.x = x;
		this.y = y;
	}
	float cross(Point other){
		return x*other.y - y*other.x;
	}
}

class Stick implements Comparable{
	int x, y1, y2;
	Stick(int x, int y1, int y2){
		this.x = x;
		this.y1 = y1;
		this.y2 = y2;
	}
	@Override
	public int compareTo(Object arg0) {
		return this.x - ((Stick)arg0).x;
	}

}

public class Main {
	
	static int y1[];
	static int y2[];
	static int numY1[];
	static int numY2[];
	static Stick[] array;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("src/input.txt"));
	    PrintWriter writer = new PrintWriter("src/output.txt", "UTF-8");

		int cases = scan.nextInt();
		while(cases-- > 0) {
			int n = scan.nextInt();
			
			array = new Stick[n];
			numY1 = new int[n];
			numY2 = new int[n];
			
			for(int i = 0; i < n; i++) { 
				array[i] = new Stick(scan.nextInt(), scan.nextInt(), scan.nextInt());
			}
			
			Arrays.sort(array);
						
			numY1[0] = 1;
			numY2[0] = 1;
			
			for(int target = 1; target < n; target++) {
				for(int start = 0; start < target; start++) {
					numY1[target] = (numY1[target] + sumY1(start, target) % 1000000007) % 1000000007;
					numY2[target] = (numY2[target] + sumY2(start, target) % 1000000007) % 1000000007;
				}
			}
			
			System.out.println((numY1[n-1] + numY2[n-1]) % 1000000007);
			writer.println();
		}
		writer.close();
	}

	private static int sumY1(int start, int end) {
		int a = 1, b = 1;
		for(int i = start + 1; i < end; i++) {
			if(!solve(new Point(array[start].x, array[start].y1),new Point(array[end].x, array[end].y1),new Point(array[i].x, array[i].y1),new Point(array[i].x, array[i].y2))) a = 0;
			if(!solve(new Point(array[start].x, array[start].y2),new Point(array[end].x, array[end].y1),new Point(array[i].x, array[i].y1),new Point(array[i].x, array[i].y2))) b = 0;
		}
		return numY1[start]*a + numY2[start]*b;
	}
	private static int sumY2(int start, int end) {
		int c = 1, d = 1;
		for(int i = start + 1; i < end; i++) {
			if(!solve(new Point(array[start].x, array[start].y1),new Point(array[end].x, array[end].y2),new Point(array[i].x, array[i].y1),new Point(array[i].x, array[i].y2))) c = 0;
			if(!solve(new Point(array[start].x, array[start].y2),new Point(array[end].x, array[end].y2),new Point(array[i].x, array[i].y1),new Point(array[i].x, array[i].y2))) d = 0;
		}
		return numY1[start]*c + numY2[start]*d;
	}

	static float ccw(Point a, Point b){
		return a.cross(b);
	}

	static boolean solve(Point a, Point b, Point c, Point d){
		float ab = ccw(new Point(b.x - a.x, b.y - a.y), new Point(c.x - a.x, c.y - a.y)) * ccw(new Point(b.x - a.x, b.y - a.y), new Point(d.x - a.x, d.y - a.y));
		float cd = ccw(new Point(d.x - c.x, d.y - c.y), new Point(a.x - c.x, a.y - c.y)) * ccw(new Point(d.x - c.x, d.y - c.y), new Point(b.x - c.x, b.y - c.y));
		if(ab == 0 && cd == 0){
			if(b.x < a.x && b.y < a.y) swap(a, b);
			if(d.x < c.x && d.y < c.y) swap(c, d);
			return !(b.x < c.x && b.y < c.y || d.x < a.x && d.y < a.y);
		}
		return ab <=0 && cd <=0;
	}

	private static void swap(Point a, Point b) {
		// TODO Auto-generated method stub
		Point temp = new Point(a.x, a.y);
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;
	}
}
