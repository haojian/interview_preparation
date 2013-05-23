package math;

public class KLdivergence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] p1= {10.1};
		double[] p2={7.67};  //4.010273782375859   -3.0454257337448354
		
		double[] p3= {4.53};
		double[] p4={6.25};  //-2.103483481949561    2.902157121895089
		
		double[] p5= {0.95};
		double[] p6={1.30};  //-0.42988659446263144    0.5882658661067587
		
		double[] p7= {59.4};
		double[] p8={0};  //Infinity   Infinity

		double[] p9= {0.23};
		double[] p10={60};  //-1.8462525107450332   481.6310897595738
		
		double[] p11= {0.90};
		double[] p12={0.90};  
		
		double[] p13= {0.20};  //22.27238809148561
		double[] p14={0.20};  //8.744691179161412
		System.out.println((klDivergence_smoothing(p11, p12)+klDivergence_smoothing(p12, p11))/2);
		System.out.println((klDivergence_smoothing(p13, p14)+klDivergence_smoothing(p13, p14))/2);
	}
	public static final double log2 = Math.log(2);

	/**
     * Returns the KL divergence, K(p1 || p2).
     *
     * The log is w.r.t. base 2. <p>
     *
     * *Note*: If any value in <tt>p2</tt> is <tt>0.0</tt> then the KL-divergence
     * is <tt>infinite</tt>. Limin changes it to zero instead of infinite. 
     * 
     */
    public static double klDivergence(double[] p1, double[] p2) {
    	if(p1.length != p2.length)
    		return -1;
    	double klDiv = 0.0;
    	for (int i = 0; i < p1.length; ++i) {
    		if (p1[i] == 0) { continue; }
    		if (p2[i] == 0.0) { continue; } // Limin
    		klDiv += p1[i] * Math.log( p1[i] / p2[i] );
    	}
    	if(klDiv == 0)
    		klDiv = Double.MAX_VALUE;
    	return klDiv / log2; // moved this division out of the loop -DM
    }
    
    public static double klDivergence_smoothing(double[] p1, double[] p2) {
    	if(p1.length != p2.length)
    		return -1;
    	double klDiv = 0.0;
    	for (int i = 0; i < p1.length; ++i) {
    		klDiv += p1[i] * Math.log( (p1[i]+0.00001) / (p2[i]+0.00001));
    	}

    	return klDiv / log2; // moved this division out of the loop -DM
    }
}
