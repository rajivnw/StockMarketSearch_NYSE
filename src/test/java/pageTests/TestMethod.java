package pageTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjs.RetrieveTestData;
import pageObjs.SearchCompany;

public class TestMethod {

	@Test
	@Parameters({"companyName"})
	public void SearchCompany(String cmpName) {
		SearchCompany searchcmp = new SearchCompany();
		searchcmp.clickToSearchBtn();
		searchcmp.enterCompany(cmpName);
		searchcmp.clickToSearchedCompany(cmpName);
	}

	@Test
	@Parameters({"companyName"})
	public void RetrieveCompanyData(String cmpName) {
		RetrieveTestData retrieveData = new RetrieveTestData();

		retrieveData.currentPrice(cmpName);
		retrieveData.lowHighPrices_52Weeks(cmpName);
		retrieveData.EPSPrice(cmpName);
	}

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
