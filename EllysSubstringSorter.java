import java.util.*;

public class EllysSubstringSorter {
	
	
	String getMin(String S, int L) {
		
		char [] str = S.toCharArray();
		
		LinkedList <Character> ll = new LinkedList<Character>();
		
		int index = 0;
		while (index < L) {
			Character ch = str[index];
			while (ll.size() > 0 && ll.peekLast() > ch) {
				ll.removeLast();
			}
			ll.offerLast(ch);
			index++;
		}
		
		int startIndex = 0;
		
		while (ll.peekFirst() == str[startIndex]) {
			ll.removeFirst();
			
			startIndex++;
			
			if (startIndex > str.length - L-1) {
			//	System.out.println("done " + startIndex);
				break;
			}
			
			while (ll.size() > 0 && ll.peekLast() > str[startIndex + L-1]) {
				ll.removeLast();
			}
			ll.offerLast(str[startIndex + L-1]);
		}
		
		Arrays.sort(str, startIndex, startIndex+L);
		return new String(str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EllysSubstringSorter ess = new EllysSubstringSorter();
		String S = "TOPCODER";
		Integer L = 4;
		System.out.println(ess.getMin(S, L));
			
	}

}
