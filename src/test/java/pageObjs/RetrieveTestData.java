package pageObjs;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBaseClass;
import testbase.WSJUtils;

public class RetrieveTestData extends TestBaseClass {

	public RetrieveTestData() {
		PageFactory.initElements(getDriver(), this);
	}

	public static HashMap<String, Float> EPSPriceMap = new HashMap<String, Float>();

	@FindBy(id = "quote_val")
	private WebElement currentPrice;

	@FindBy(xpath = ".//*[text()='52 Week Range']/following-sibling::*[@class='data_data']")
	private WebElement weekRange_52;

	@FindBy(xpath = ".//*[contains(text(),'EPS')]/following-sibling::*[@class='data_data']")
	private WebElement EPS;

	public WebElement getEPS() {
		return EPS;
	}

	public WebElement getCurrentPrice() {
		return currentPrice;
	}

	public WebElement getWeekRange_52() {
		return weekRange_52;
	}

	public void currentPrice(String cmp) {
		float currentPrice = Float.valueOf(getCurrentPrice().getText());
		System.out.println("currentPrice for " + cmp + " " + currentPrice);
	}

	public void lowHighPrices_52Weeks(String cmp) {
		String[] rangePrice_52Weeks = getWeekRange_52().getText().split("-");
		float lowPrice = Float.valueOf(rangePrice_52Weeks[0]);
		float highPrice = Float.valueOf(rangePrice_52Weeks[1]);
	}

	public void EPSPrice(String cmp) {
		WSJUtils.waitForPageLoad();
		float epsPrice = Float.valueOf(getEPS().getText().trim().replaceAll("[$]", ""));

		if (getDriver().getCurrentUrl().endsWith(cmp)) {
			System.out.println("epsPrice for first " + epsPrice);
			EPSPriceMap.put(cmp, epsPrice);
		} else {
			System.out.println("value not entered in map");
		}

		System.out.println("-----------------------------------------------");

	}

}
