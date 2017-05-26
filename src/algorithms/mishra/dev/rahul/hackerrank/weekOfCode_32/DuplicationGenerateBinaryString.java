package algorithms.mishra.dev.rahul.hackerrank.weekOfCode_32;

public class DuplicationGenerateBinaryString {

	public static void main(String[] args) {
		String s = "0";
		while(s.length() <= 1000) {
			System.out.print("S: " + s + " ");
			s = s + findOnesComplement(s);
		}
		System.out.println("Final:" + s);
	}
	
	private static String findOnesComplement(String s) {
		String complement = "";
		for(int i = 0; i < s.length(); i++) {
			if("0".equals(String.valueOf(s.charAt(i)))) {
				complement = complement + "1";
			} else if("1".equals(String.valueOf(s.charAt(i)))) {
				complement = complement + "0";
			}
		}
		System.out.print("Complement: " + complement + "\n");
		return complement;
	}

}
