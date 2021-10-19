package testscrpt2;

import org.testng.annotations.Test;

public class sample2Test {



		@Test(groups= {"regressionTest"})
		public void testsample1()
		{
		System.out.println("test2.1 executing");
		
		}
		
		@Test(groups= {"smokeTest"})
		public void testsample2()
		{
		System.out.println("test2.2 executing");
		
		}
	}


