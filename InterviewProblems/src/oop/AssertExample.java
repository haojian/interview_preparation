package oop;

public class AssertExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ifenable = false;
		//assert ifenable==true : "not enabled";
		assert ifenable=true;  
		    if(ifenable==false){  
		      throw new RuntimeException("Assertion shoule be enable!");  
		    }
		boolean comp = 1>2;
		assert comp;
	}

}
