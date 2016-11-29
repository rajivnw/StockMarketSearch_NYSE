package pageTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjs.RetrieveTestData;

public class ComparePrices_test {

	@Test
	@Parameters({"firstCompareCMP", "secondCompareCMP"})
	public void compareEPS(String firstCMP, String secondCMP) {

		int cmpr = Float.compare(RetrieveTestData.EPSPriceMap.get(firstCMP),
				RetrieveTestData.EPSPriceMap.get(secondCMP));
		if (cmpr > 0) {
			System.out.println(firstCMP + " EPS is greater than " + secondCMP);
		} else if (cmpr < 0) {
			System.out.println(firstCMP + " EPS is less than " + secondCMP);
		} else {
			System.out.println(firstCMP + " EPS is equal to " + secondCMP);
		}
	}

}
