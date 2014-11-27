import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class HourGlass {
	
	int glass1max;
	int glass2max;
	HashSet <Integer> visited = new HashSet<Integer> ();
	
	public class myComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return Integer.compare(arg1, arg0);
		}
		
	}
	
	private void flip(PriorityQueue<Integer> pq, int glass1, int glass2, int time) {
		
		if (pq.size() == 11 && time > pq.peek())
			return;
		
		if (glass1 == 0 && glass2 == 0) {
			
			if (pq.size() == 11 && time > pq.peek())
				return;
			
			if (!visited.contains(time)) {
				if (pq.size() == 11) {
					int rem = pq.poll();
						visited.remove(rem);
				}
							
				pq.add(time);
				visited.add(time);
			}
			return;
		}
		
		if (glass1 == 0) {
			flip (pq, 0, 0, time + glass2);
			return;
		}
		
		if (glass2 == 0) {
			flip (pq, 0, 0, time + glass1);
			return;
		}
		
		if (pq.size() == 11 && time > pq.peek())
			return;
		
		
		if (!visited.contains(time)) {
			
			if (pq.size() == 11)  {
				int rem = pq.poll();
				visited.remove(rem);
			}
			
			pq.add(time);
			visited.add(time);
		}
		
		flip (pq, 0, Math.max(glass1, glass2), time + Math.min(glass1, glass2));
		
		int min = Math.min(glass1, glass2);
		glass1 -= min;glass2 -= min;
		time += min;
		
		flip (pq, glass1, glass2, time);
		flip (pq, glass1max - glass1, glass2, time);
		flip (pq, glass1, glass2max - glass2, time);
		flip (pq, glass1max - glass1, glass2max - glass2, time);
	
	}
	
	public  int[] measurable(int glass1, int glass2) {
		
		int [] result = new int [10];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer> (10, new myComparator());
		
		glass1max = glass1;
		glass2max = glass2;
		
		flip(pq, glass1, glass2, 0);
		
		int counter = 0;
		for (Integer integer : pq) {
			
			if (integer != 0)
				result[counter++] = integer;
			
		}
		Arrays.sort(result);
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HourGlass hg = new HourGlass();
		int [] result;
		int glass1 = 5;
		int glass2 = 7;
		result = hg.measurable(glass1, glass2);
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
