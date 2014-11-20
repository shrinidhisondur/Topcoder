
public class AlienAndGame {

	public int getNumber(String[] board) {
		
		int l = Math.min(board.length, board[0].length());
		
		while (l > 0) {
			StringBuffer sb1 = new StringBuffer ();
			StringBuffer sb2 = new StringBuffer ();
			for (int i = 0; i < l; i++) {
				sb1.append ("W");
				sb2.append ("B");
			}
			boolean breaking = false;
			for (int i = 0; i <= board.length - l; i++) {
				for (int j = 0; j <= board[0].length() - l; j++) {
					for (int a = i; a < i + l; a++) {
						if (!board[a].substring(j, j + l).equals(sb1.toString()) && 
								!board[a].substring(j, j + l).equals(sb2.toString())) {
							breaking = true;
							break;
						}
					}
					if (!breaking) {
						return l*l;
					}
					breaking = false;
				}
			}
			l--;
		}
		
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] input = {"BWBBWBB",
				 "WWBWWBW",
				 "BBBBBBW",
				 "WBBBBWB",
				 "BBWWWWB",
				 "WWWWWWW",
				 "BBWWBBB"};
		
		AlienAndGame a = new AlienAndGame();
		System.out.println(a.getNumber(input));
	}

}
