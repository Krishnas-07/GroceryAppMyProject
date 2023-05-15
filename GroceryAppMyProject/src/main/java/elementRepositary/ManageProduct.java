package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;

public class ManageProduct {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageProductTab;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[6]//td[9]//a[1]")
	WebElement editTab;
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategory;
	@FindBy(xpath = "(//label[@class='radio-inline'])[1]")
	WebElement editProduct;
	@FindBy(xpath = "//label[@onclick='myFunction_weight(this.value)']")
	WebElement editPriceType;
	@FindBy(id = "m_weight")
	WebElement editWeightValue;
	@FindBy(id = "w_unit")
	WebElement editWeightUnit;
	@FindBy(id = "w_price")
	WebElement editPrice;
	@FindBy(id = "w_stock")
	WebElement editStockAvailability;
	@FindBy(id = "w_mrp")
	WebElement mrp;
	@FindBy(id = "max_weight")
	WebElement maxQuantiy;
	@FindBy(id = "cat_id")
	WebElement category;

	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;

	public void clickManageProductTab() {
		gu.clickTab(manageProductTab);
	}

	public void clickEditTab() {
		gu.clickTab(editTab);
	}

	public void selectSubCategory() {
		gu.selectFromDropDown(subCategory, 11);
	}

	public void editProductType() {
		gu.clickTab(editProduct);
	}

	public void editPriceType() {
		gu.clickTab(editPriceType);
	}

	public void addWeightValue() {
		gu.addText(editWeightValue, "300");
	}

	public void addWeightUnit() {
		gu.selectFromDropDown(editWeightUnit, 2);
	}

	public void addPrice() {
		gu.addText(editPrice, "300");
	}

	public void addStockAvaialability() {
		gu.addText(editStockAvailability, "10kg");
	}

	public void addMaximumQuantity() {
		gu.addText(maxQuantiy, "50");
	}

	public void addMRP() {
		gu.addText(mrp, "500");
	}

	public void clickUpdateButton() {
		gu.clickTab(updateButton);
	}

	public void selectCategory() {
		gu.selectFromDropDown(category, 0);

	}

	public boolean selectionCheck() {
		return gu.checkSelection(category);
	}
	public boolean enableCheck() {
		return gu.enabledOrNot(updateButton);
	}

}
