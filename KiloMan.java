
public class KiloMan {

	public int hitsTaken(int[] pattern, String jumps) {
		
		int index = 0;
		
		int hits = 0;
		while (index < pattern.length) {
			
			if (jumps.charAt(index) == 'S' && pattern[index] <= 2) {
				hits++;
			} else if (jumps.charAt(index) == 'J' && pattern[index] > 2) {
				hits++;
			}
			index++;
		}
		return hits;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
