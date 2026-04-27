package com.PomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class responseNodePage {

    @FindBy(xpath = "//p[text()='Set Response' and @class='color-text-regular fs-12px fw-500']/ancestor::div[@class='border-stroke-section-1px bg-surface-l2 br-4px custom__node-wrapper  position-relative']")
    private WebElement responseNodeElement;
    
    @FindBy(xpath = "//div[text()='Select type']/ancestor::div[@class='css-13cymwt-control']/descendant::div[@class='css-1wy0on6']")
    private WebElement selectTypeDropDownElement;
    
    @FindBy(xpath = "//div[text()='JSON']")
    private WebElement selectTypeAsJsonElement;
    
    @FindBy(xpath = "//div[@class='view-lines monaco-mouse-cursor-text']")
    private WebElement responseBodyPayloadTextFieldElement;
    
    @FindBy(xpath = "//p[@class='color-text-regular fs-13px fs-13px fw-500' and text()='Save']")
    private WebElement responseSaveButtonElement;
    
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElement ActualResponseSaveToastMsg;
    
    @FindBy(xpath = "//p[@class='fw-500 fs-13px color-text-heading' and text()='Build']/ancestor::div[@class='flex-row ddHover hz-space-between vt-center w-100 h-36px mainTopSection px-8px']/descendant::div[@class='flex-row hz-space-between vt-center']")
    private WebElement MainSaveButton;
    
    
}
