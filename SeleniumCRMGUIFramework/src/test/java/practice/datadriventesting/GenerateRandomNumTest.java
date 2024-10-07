package practice.datadriventesting;

import java.util.Random;

public class GenerateRandomNumTest {

	public static void main(String[] args) {
		Random random = new Random();
		int randomInt = random.nextInt(1000); //upper limit is 1000 
		System.out.println(randomInt); // 0 to 1000

	}

}
