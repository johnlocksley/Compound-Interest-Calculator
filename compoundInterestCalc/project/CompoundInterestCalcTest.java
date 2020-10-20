package compoundInterestCalc.project;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CompoundInterestCalcTest {
	private double p;
	private double r;
	private int n;
	private int t;
	private double expectedResult;
	private CompoundInterestCalc compoundInterestCalc;
	
	
	public CompoundInterestCalcTest(double p, double r, int n, int t, double expectedResult) {
		  this.p = p;
	      this.r = r;
	      this.n = n;
	      this.t = t;
	      this.expectedResult = expectedResult;
	   }
	
	@Before
	   public void initialize() {
	      compoundInterestCalc = new CompoundInterestCalc();
	   }
	
	@Parameterized.Parameters
	   public static Collection calcParams() {
	      return Arrays.asList(new Object[][] {
	         { 5000, 5, 12, 10, 8235.05 },
	         { 10700, 8, 1, 25, 73278.68 },
	         { 0, 10, 15, 12, 0 },
	         { 100, 0, 20, 20, 100 },
	      });
	   }

	@Test
	public void testCalcAmount() {
		double amount = compoundInterestCalc.calcAmount(p, r, n, t);
		assertEquals(expectedResult, amount, 0.01);  
	} 
}
