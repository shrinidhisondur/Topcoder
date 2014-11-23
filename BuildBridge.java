
public class BuildBridge {
	
	public int howManyCards(int D, int L)
    {
        double res = 0;
        double eps = 1e-9;
        for (int i = 1; ; i++)
        {
            res += (double)L / i / 2;
            if (res + eps > D) return i;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuildBridge bb = new BuildBridge();
		int D = 9;
		int L = 1;
		System.out.println(bb.howManyCards(D, L));
	}

}
