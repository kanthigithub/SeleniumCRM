package practice.datadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		
		int n=20; //length of AlphaNumreicString
		
		//choose a character randomly from this string
		String AlphaNumStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create String size of  n
		StringBuilder sb = new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
			//generate a random num between 0 to AlphaNumStr variable length
			int index = (int)(AlphaNumStr.length() * Math.random());
		
			//add character one by one in the end of sb
			sb.append(AlphaNumStr.charAt(index));
			
		}
		System.out.println(sb);

	}

}
