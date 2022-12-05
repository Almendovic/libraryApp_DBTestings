package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class US3_Step_Definition {
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    List<String> actualCategoryList;


    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
      loginPage.login("librarian");
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String moduleName) {
     new DashBoardPage().navigateModule(moduleName);


    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);
    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories;");


    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db(List<String> expectedCategoryList) {

        Assert.assertEquals(actualCategoryList,expectedCategoryList);

    }

}
