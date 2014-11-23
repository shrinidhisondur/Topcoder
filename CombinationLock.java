
public class CombinationLock {

	public double degreesTurned(int[] combo, int size, int start) {
		
		int N = combo.length;
		double degrees = 0;
		int index = 0;
		
		degrees += N*360;
		N -= 1;
		
		int diff = combo[index] - start;
		if (diff > 0) {
			degrees += 360*(float)Math.abs(diff)/size;
		} else {
			degrees += 360*(float)(size-Math.abs(diff))/size;
		}
		
		int clockWise = -1;
		while (index < combo.length) {
			degrees += N*360;
			index++;
			
			if (index == combo.length)
				break;
			
			diff = combo[index] - combo[index-1];
			if (clockWise*diff > 0) {
				degrees += 360*(float)Math.abs(diff)/size;
			} else {
				degrees += 360*(float)(size-Math.abs(diff))/size;
			}
			clockWise *= -1;
			N = N-1;
		}
		return degrees;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationLock cl = new CombinationLock();
		int [] combo = {10,20,30};
		int size = 40;
		int start = 6;
		System.out.println(cl.degreesTurned(combo, size, start));
	}

}
