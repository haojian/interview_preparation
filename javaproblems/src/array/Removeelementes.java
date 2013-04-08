package array;

public class Removeelementes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1};
		System.out.println(removeElement(input, 1));
	}

	
	public static int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ei = A.length -1;
        int si = 0;
        while(si<=ei){
            if(A[si] == elem){
                valExchange(A, ei, si);
                ei--;
            }else{
                si++;
            }
        }
        return (ei+1);
    }
    
    public static void valExchange(int[] A, int i1, int i2){
        if(A[i1]!= A[i2]){
            A[i1] = A[i1] ^A[i2];
            A[i2] = A[i1] ^A[i2];
            A[i1] = A[i1] ^ A[i2];
        }
    }
}
