package org.bddExample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dendy
 * @Date 31/05/2022
 * @Time 10.22
 * Description :
 */
public class IsItFridayTest {
    private String today;
    private String actualAnswer;

    //mendifine state awal
    @Given("today is Sunday")
    public void today_is_sunday() {
        today = "Sunday";
    }

    @Given("today is Friday")
    public void today_is_friday() {
        today = "Friday";
    }

    @Given("today is {string}")
    public void today_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        today = string;
    }

    //proses
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    //output
    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        assertEquals(string, actualAnswer);
    }
}
