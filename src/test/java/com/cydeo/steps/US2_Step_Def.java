package com.cydeo.steps;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

public class US2_Step_Def extends DashBoardPage  {

    LoginPage loginPage = new LoginPage();


    int actualBorrowedBooksNumber;





    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login("librarian");


    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualBorrowedBooksNumber=Integer.parseInt(borrowedBooksNumber.getText());

        System.out.println(borrowedBooksNumber.getText());

    }
    @Then("borrowed books number information must match with DB")

    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("SELECT count(*) from book_borrow\n" +
                "where is_returned=0;");
 int expectedBorrowBooksNumber= Integer.valueOf(DB_Util.getFirstRowFirstColumn());

        Assert.assertEquals(expectedBorrowBooksNumber,actualBorrowedBooksNumber);

    }




}
