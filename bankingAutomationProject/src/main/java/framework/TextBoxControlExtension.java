package framework;

import org.openqa.selenium.WebElement;

public class TextBoxControlExtension {
	private WebElement wrappedElement;

	public TextBoxControlExtension(WebElement element) {
		this.wrappedElement = element;
	}

	public void setValue(String text) {
		this.wrappedElement.sendKeys(text);

		String actualValue = this.getValue();
		if(!actualValue.equals(text)) {
			throw new RuntimeException("The textbox could not be set to '" + text + "'. Actual value was '" + actualValue + "'");
		}
	}

	public String getValue() {
		return this.wrappedElement.getAttribute("value");
	}
}