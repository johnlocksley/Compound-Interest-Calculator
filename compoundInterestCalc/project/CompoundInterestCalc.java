package compoundInterestCalc.project;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundInterestCalc {
	private double amount;
	private int places;
	
	public CompoundInterestCalc() {
		places = 2;
	}
	
	
	public double calcAmount(double p, double r, int n, int t) {
		r = r /100;
		amount = p * Math.pow(1 + (r / n), n * t);
		BigDecimal bd = new BigDecimal(Double.toString(amount));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
		
	}
}
