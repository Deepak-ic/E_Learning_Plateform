package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_Learning_POM {

	public E_Learning_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	curser icon
	@FindBy(xpath = "//*[@class='cursor-pointer']")
	private WebElement curIcon;

//	Sign in Button
	@FindBy(xpath = "//*[text()='Sign in']")
	private WebElement signBtn;

//	Username Text box
	@FindBy(id = "username")
	private WebElement usrnameTxt;

//	Password Text Box
	@FindBy(id = "password")
	private WebElement passTxt;
	
//	Continue Button
	@FindBy(name = "action")
	private WebElement submit;

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public WebElement getCurIcon() {
		return curIcon;
	}

	public void setCurIcon(WebElement curIcon) {
		this.curIcon = curIcon;
	}

	public WebElement getSignBtn() {
		return signBtn;
	}

	public void setSignBtn(WebElement signBtn) {
		this.signBtn = signBtn;
	}

	public WebElement getUsrnameTxt() {
		return usrnameTxt;
	}

	public void setUsrnameTxt(WebElement usrnameTxt) {
		this.usrnameTxt = usrnameTxt;
	}

	public WebElement getPassTxt() {
		return passTxt;
	}

	public void setPassTxt(WebElement passTxt) {
		this.passTxt = passTxt;
	}

}
