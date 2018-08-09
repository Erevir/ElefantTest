import PageFactory.PagesFlow.*;
import Utils.BaseTest;
import org.junit.Test;

public class TestFlow1 extends BaseTest {


    @Test
    public void firstTest() throws InterruptedException {
        ParfumesPage homePage1 = new ParfumesPage(driver);
        MenParfumesProductsPage menParfumesProductsPage=new MenParfumesProductsPage(driver);
        ParfumeCosmeticsPage parfumeCosmeticsPage=new ParfumeCosmeticsPage(driver);
        ProductPage productPage=new ProductPage(driver);
        MyCartPage myCartPage=new MyCartPage(driver);

        homePage1.hoverOnMenParfumesButton();
        parfumeCosmeticsPage.clickOnMenParfumesButton();
        menParfumesProductsPage.selectProduct();
        menParfumesProductsPage.verifyTitle();
        menParfumesProductsPage.clickChoosenProduct();
        productPage.addToCart();
        myCartPage.clickCartButton();
        myCartPage.verifyChoosenProduct();
        Thread.sleep(2500);
        driver.close();
    }

}

