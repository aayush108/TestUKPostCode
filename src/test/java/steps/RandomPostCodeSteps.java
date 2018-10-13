package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RandomPostCodeSteps {

    private Response response;
    private RequestSpecification request;

//    @Before
//    public void setUp() {
//        RestAssured.baseURI = "http://api.postcodes.io";
//        RestAssured.basePath = "/random/postcodes";
//    }


    @Given("^The random postcode endpoint is up and running$")
    public void theRandomPostcodeEndpointIsUpAndRunning() throws Throwable {
        request = given();
    }


    @When("^I call the get random postcode end point$")
    public void iCallTheGetRandomPostcodeEndPoint() throws Throwable {
        response = request.when().get("http://api.postcodes.io/random/postcodes");
        response.then().log().all();
    }

    @Then("^I should get the response status back \"([^\"]*)\"$")
    public void iShouldGetTheResponseStatusBack(String statusCode) throws Throwable {
        response.then().statusCode(Integer.parseInt(statusCode));
    }

    @And("^content type of response should be in the \"([^\"]*)\" format$")
    public void contentTypeOfResponseShouldBeInTheFormat(String format) throws Throwable {
        if(format.equals("JSON")){
            response.then().assertThat().contentType(ContentType.JSON);
        }
    }


}
