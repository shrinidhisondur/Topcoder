import java.util.*;

public class SplitIntoPairs {

	public int makepairs(int[] A, int X) {

		ArrayList <Integer> neg = new ArrayList<Integer>();
		ArrayList <Integer> pos = new ArrayList<Integer>();
		
		int maxN = Integer.MIN_VALUE;
		int minP = Integer.MAX_VALUE;
		int maxNPos = -1;
		int minPPos = -1;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0) {
				if (maxN < A[i]) {
					maxN = A[i];
					maxNPos = neg.size();
				}
				neg.add(A[i]);
			} else {
				if (minP > A[i]) {
					minP = A[i];
					minPPos = pos.size();
				}
				pos.add(A[i]);
			}
		}
		int counter = 0;
		
		if (neg.size()%2 == 1) {
			neg.remove(maxNPos);
			pos.remove(minPPos);
			if ((long)maxN * minP >= X) {
				counter++;
				System.out.println(maxN + " " + minP);
			}
		}
		
		Collections.sort (neg);
		Collections.sort (pos);
		
		int i = 0;int j = pos.size()-1;
		
		while (i < j) {
			
			if ((long)pos.get(i) * pos.get(j) >= X) {
				System.out.println(pos.get(i) + " " + pos.get(j));
				counter++;
				i++;j--;
			} else {
				i++;
			}
		}
		
		i = 0;j = neg.size()-1;
		
		while (i < j) {
			
			if ((long)neg.get(i) * neg.get(j) >= X) {
				counter++;
				System.out.println(neg.get(i) + " " + neg.get(j));
				i++;j--;
			} else {
				i++;
			}
		}

		
		return counter;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SplitIntoPairs sp = new SplitIntoPairs();
		int [] A = {-2, -4, -4, 3, 0, -4, 0, -3, -4, 2};
		int X = -1;
		
		System.out.println(sp.makepairs(A, X));
	}

}
