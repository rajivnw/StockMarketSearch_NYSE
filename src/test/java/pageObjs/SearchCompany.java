package pageObjs;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBaseClass;
import testbase.WSJUtils;

public class SearchCompany extends TestBaseClass {

	public SearchCompany() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='searchButtonSwitcher']")
	private WebElement searchCompanyBox;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter News, Quotes, Companies')]")
	private WebElement enterCmpTextBox;

	@FindBy(xpath = ".//ul[@class='symbols']/li[@class='result-item']")
	private List<WebElement> SearchedCmpList;

	public WebElement getClickOnSearchIcon() {
		return searchCompanyBox;
	}

	public WebElement getEnterCmpTextBox() {
		return enterCmpTextBox;
	}

	public List<WebElement> getSearchedCompany() {
		return SearchedCmpList;
	}

	public void clickToSearchBtn() {
		System.out.println("clicking on search btn");
		getClickOnSearchIcon().click();
	}

	public void enterCompany(String cmp) {
		getEnterCmpTextBox().clear();
		System.out.println("Searching... NYSE Company:- " + cmp);
		getEnterCmpTextBox().sendKeys(cmp);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickToSearchedCompany(String cmp) {
		if (getSearchedCompany().size() > 0) {
			for (int i = 0; i < getSearchedCompany().size(); i++) {

				if (getSearchedCompany().get(i).getText().contains(cmp)
						&& getSearchedCompany().get(i).getText().contains("U.S.: NYSE")) {
					getSearchedCompany().get(i).click();
					WSJUtils.waitForPageLoad();
					System.out.println("NYSE listed company: " + cmp
							+ " clicked from the search list");

				}
			}

		} else {
			System.out.println("no company found with the entered name");
		}

	}

}
