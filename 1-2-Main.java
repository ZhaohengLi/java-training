import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();

		BigInteger one = new BigInteger(s1);
		System.out.println("This is A: "+s1.toString());

		BigInteger two = new BigInteger(s2);
		System.out.println("This is B: "+s1.toString());

		BigInteger sum1 = one.add(two);
		BigInteger sum2 = two.add(one);
		System.out.println("This is A+B: "+sum1.toString());
		System.out.println("This is B+A: "+sum2.toString());
	}
}

class BigInteger {
	// TODO define user specified fields
	// Warning 1: For Open and Close Principle, non-private fields are illegal.
	// Warning 2: References, arrays contain High-precision Numbers are illegal.
	//          For extension, all non-primitive or non-Number types are illegal.
	// Example for 1: public int len;(error) -> private int len;(correct)
	// Example for 2: java.math.BigInteger $233;(error) -> Number $233;(error) -> Object $233;(error)
	// Example for 2(extension): java.util.Vector $233;(error)
	// Example(primitive): int[] num, nn[];(correct)
	// Example(box primitive to Number): Integer[] num, nn[];(correct)
	
	private int[] array = null;

	
	/**
	 * This constructor convert String to BigInteger.
	 * @param s The input String, only contains character 0-9.
	 */
	BigInteger(final String s) {
		if(s.length()!=0) {
			this.array = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				this.array[i] = Character.getNumericValue(s.charAt(i));
			}
		}else {
			this.array = new int[1];
			array[0] = 0;
		}
	}
	
	
	/**
	 * Calculate the value of (this + val).
	 * This method don't change input arguments.
	 * @param val The value to add to this.
	 * @return A new Integer whose value is (this + val).
	 */
	public BigInteger add(final BigInteger val) {
		final BigInteger v=(BigInteger) val;
		
		int[] n1 = reverseArray(this.array);
		int[] n2 = reverseArray(v.getArray());
		
		int resultlength = n1.length > n2.length ? n1.length + 1 : n2.length + 1;
		int[] n3 = new int[resultlength];
		for (int i=0; i<resultlength; i++) n3[i] = 0;
		
		
		int temp = 0;
		int bTemp = 0;
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < n3.length - 1; i++) {
			if (i < n1.length) num1 = n1[i];
			else num1 = 0;
			
			if (i < n2.length) num2 = n2[i];
			else num2 = 0;
			
			temp = num1 + num2 + n3[i];
			
			if (temp >= 10) {
				bTemp = 1;
				temp = temp - 10;
			}else {
				bTemp = 0;
			}
			
			n3[i] = temp;
			if (bTemp > 0) n3[i+1] = bTemp;
		}
		
		n3 = reverseArray(n3);
		
		StringBuffer buffer = new StringBuffer("");
		int location = 0;
		for (int i=0; i<n3.length; i++){
			if (n3[i] != 0) {
				location = i; break;
			}
			if (i == n3.length-1) location = n3.length;
		}
		for (int i=location; i<n3.length; i++) buffer.append(n3[i]);
		
		BigInteger result = new BigInteger(buffer.toString());
		return result;
		
	}
	
	
	/**
	 * Convert this to String.
	 * @return The String representation of this.
	 */
	public String toString() {
		final StringBuilder s=new StringBuilder();
		for (int num : this.array) {
			s.append(num);
		}
		return s.toString();
	}
	
	
	// TODO define user specified methods
	public static int[] removeZero(int[] array){
		int count = 0;
		for (int i = array.length - 1; i >= 0; i--) if (array[i] == 0) count ++;

		if (count > 0) {
			int[] result = new int[array.length - count];
			for (int i = 0; i < result.length; i++) {
				result[i] = array[i];
			}
			array = result;
		}
		return array;
	}
	
	public static int[] reverseArray(int[] array){
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[array.length - 1 - i];
		}
		return result;
	}
	
	public int[] getArray() {
		return this.array;
	}
	
	
}
