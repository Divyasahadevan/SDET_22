package testscrpt1;

import org.testng.annotations.Test;

public class sample1test {
	@Test(groups= {"regressionTest"})
	public void test1()
	{
	System.out.println("test1 executing");
	
	}
	
	@Test
	public void test2()
	{
	System.out.println("test2 executing");
	
	}
}
