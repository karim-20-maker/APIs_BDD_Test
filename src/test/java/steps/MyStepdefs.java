package steps;

import apiConfig.HeaderConfg;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static base.Data.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class MyStepdefs {
    RequestSpecification getRequest ;
    Response response;
    HeaderConfg header = new HeaderConfg();

    @Before
    public void BaseURI () {
        RestAssured.baseURI = BASEURL ;
    }

    @Given("colour lovers URL")
    public void colourLoversURL() {
        getRequest = RestAssured.given();

        System.out.println("1-here is the base url  =====> " + BASEURL);
    }


    @When("user calls patterns  End Point with get http request")
    public void user_calls_patterns_End_Point_with_get_http_request() {
        response = getRequest.when().headers(header.defaultHeaders()).get(EndPoint); // using header config to send agent , content type into headers && set end point && using get method
        System.out.println("2-and here is the base url/endPoint   =====> " + BASEURL + "/patterns");
    }



    @Then("Should get numViews value from numViews Path and that value should be greater than  {string}")
    public void should_get_numViews_value_from_numViews_Path_and_that_value_should_be_greater_than( String value) {
        response.then().assertThat()  // make sure that num views  >  4000
                .body(numViews_Path,greaterThan(value));
        System.out.println( "3-here is the actual numviews ===>  " + response.then().extract().path(numViews_Path).toString()); // extract the real numview value from response body!
    }

    @And("the API call must got success with status code  {int}")
    public void the_API_call_must_got_success_with_status_code(Integer statusCode) {

        response.then().assertThat().statusCode(statusCode);  //make sure that status code into response = 2xx
        System.out.println( "4-and finally here is the actual status code  ===>  " + response.then().extract().statusCode());

    }



}
