import PageFactory.PagesFlow.MenParfumesProductsPage;
import PageFactory.PagesFlow.ParfumeCosmeticsPage;
import PageFactory.PagesFlow.ProductPage;
import Utils.BaseTest;
import PageFactory.PagesFlow.ParfumesPage;
import org.junit.Test;

public class TestFlow1 extends BaseTest {


    @Test
    public void firstTest() {
        ParfumesPage homePage1 = new ParfumesPage(driver);
        MenParfumesProductsPage menParfumesProductsPage=new MenParfumesProductsPage(driver);
        ParfumeCosmeticsPage parfumeCosmeticsPage=new ParfumeCosmeticsPage(driver);
        ProductPage productPage=new ProductPage(driver);

        homePage1.hoverOnMenParfumesButton();
        parfumeCosmeticsPage.clickOnMenParfumesButton();
        menParfumesProductsPage.selectProduct();
        menParfumesProductsPage.verifyTitle();
        menParfumesProductsPage.clickChoosenProduct();
        productPage.addToCart();

    }

}

