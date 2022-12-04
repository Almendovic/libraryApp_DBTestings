package com.cydeo.steps;

import com.cydeo.pages.LoginPage;
import io.cucumber.java.en.*;

public class US3_Step_Definition {
    LoginPage loginPage = new LoginPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
      loginPage.login("librarian");
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {

    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {

    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

    }

}
