
public class EllysNumberGuessing {
	
	final int MIN = 1;
	final int MAX = 1000000000;
	
	private boolean isValid (int number) {
		return number >= MIN && number <= MAX;
	}
	
	public int getNumber(int[] guesses, int[] answers) {
		
		int pos1 = answers[0] + guesses[0] > MAX ? -1 : answers[0] + guesses[0];
		int pos2 = -answers[0] + guesses[0] <= 0 ? -1 : -answers[0] + guesses[0];
		int ans = -1;
		
		if (pos1 == -1 && pos2 == -1)
			return -2;
		
		if (pos1 == -1) ans = pos2;
		if (pos2 == -1) ans = pos1;
		
		int index = 1;
		
		if (ans == -1) {
			while (index < guesses.length && guesses[index] == guesses[index-1] ) { if (answers[index] != answers[index-1]) return -2; index++;}
			
			if (index >= guesses.length) return -1;
			
			if (isValid(answers[index] + guesses[index])) {
				if (pos1 == answers[index] + guesses[index]) {
					ans = pos1;
				} else if (pos2 == answers[index] + guesses[index]) {
					ans = pos2;
				}
			}
			
			if (isValid(-answers[index] + guesses[index])) {
				if (pos1 == -answers[index] + guesses[index]) {
					ans = -answers[index] + guesses[index];
				} else if (pos2 == -answers[index] + guesses[index]) {
					ans = pos2;
				}
			}
		}
		
		if (ans == -1) {
			System.out.println("WTF");
			return ans-1;
		}
		
		while (index < answers.length) {
			boolean match = false;
			if (isValid(answers[index] + guesses[index])) {
				if (ans == answers[index] + guesses[index]) {
					match = true;
				}
				
			}
			
			if (isValid(-answers[index] + guesses[index])) {
				if (ans == -answers[index] + guesses[index]) {
					match = true;
				}
							
			}
			
			if (!match)
				return -2;
			index++;
		}
		
		return ans;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EllysNumberGuessing eg = new EllysNumberGuessing();
		int [] guesses = {3, 3};
		int [] answers = {1, 2};
		//= {42};
		
		System.out.println(eg.getNumber(guesses, answers));
	}

}
