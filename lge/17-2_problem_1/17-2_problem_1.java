import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("src/input.txt"));
	    PrintWriter writer = new PrintWriter("src/output.txt", "UTF-8");
	    
	    Map<Integer, Map<Integer, Integer>> map = new ConcurrentHashMap<Integer, Map<Integer, Integer>>();
	    Map<Integer, Integer> temp;
	    
		int cases = scan.nextInt();
		
		while(cases-- > 0) {
			map.clear();
			int nInfection = scan.nextInt();
			while(nInfection-- > 0) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				temp = new ConcurrentHashMap<Integer, Integer>();
				temp.put(y, 0);
				map.put(x, temp);
			}

			boolean bDone = false;
			int cnt = 0, x, y;
			Integer ll = -1, lt = -1, tt = -1, l = -1, t = -1;
			
			Map<Integer, Integer> mx0, mx1, mx2, mapX;
			
			while(bDone == false) {
				bDone = true;
				cnt++;
				
				for(Entry<Integer, Map<Integer, Integer>> entryX : map.entrySet()) {
					x = entryX.getKey();
					mapX = entryX.getValue();
										
					for(Entry<Integer, Integer> entryY : mapX.entrySet()) {
						y = entryY.getKey();
						
						mx0 = mapX;
						mx1 = map.get(x-1);
						mx2 = map.get(x-2);
						
						if(mx0 == null)ll = -1;
						else ll = mx0.get(y-2);
						
						
						if(mx0 == null)ll = -1;
						else ll = mx0.get(y-2);
						
						if(mx1 == null)lt = -1;
						else lt = mx1.get(y-1);

						if(mx2 == null)tt = -1;
						else tt = mx2.get(y);

						if(mx0 == null)l = -1;
						else l = mx0.get(y-1);
						
						if(mx1 == null)t = -1;
						else t = mx1.get(y);

						if (ll == null) ll = -1;
						if (lt == null) lt = -1;
						if (tt == null) tt = -1;
						if (l == null) l = -1;
						if (t == null) t = -1;
						
						
						if(ll >= 0 && ll < cnt && l == -1 && y-1 > 0) {
							mx0.put(y-1, cnt);
							bDone = false;
						}
						if(lt >= 0 && lt < cnt && x-1 > 0 && y-1 > 0) {
							if(l == -1) {
								mx0.put(y-1, cnt);
								bDone = false;
							}
							if(t == -1) {
								if(mx1 == null) {
									mx1 = new ConcurrentHashMap<Integer, Integer>();
									mx1.put(y, cnt);
									map.put(x-1, mx1);
								} else {
									mx1.put(y, cnt);
								}
								bDone = false;
							}
						}
						if(tt >= 0 && tt < cnt && t == -1 && x-1 > 0) {
							if(mx1 == null) {
								mx1 = new ConcurrentHashMap<Integer, Integer>();
								mx1.put(y, cnt);
								map.put(x-1, mx1);
							} else {
								mx1.put(y, cnt);
							}
							bDone = false;
						}
					}
				}
			}
			System.out.println(cnt-1);
		    writer.println(cnt-1);
		}
		writer.close();
	}
}

