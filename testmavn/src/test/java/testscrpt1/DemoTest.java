package testscrpt1;

import org.testng.annotations.Test;

public class DemoTest {

	@Test(groups={"smokeTest"})
	public void createCustomerTest()
     {
		System.out.println("execute createCustomerTest");
	}
	

@Test(groups={"regressionTest"})
	public void modifyCustomerTest()
     {
		System.out.println("execute modifyCustomerTest");
     }


}
