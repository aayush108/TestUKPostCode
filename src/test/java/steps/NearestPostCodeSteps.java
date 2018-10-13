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

public class NearestPostCodeSteps {

    private Response response;
    private RequestSpecification request;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://api.postcodes.io";
        RestAssured.basePath = "/postcodes";
    }

    @Given("^I have valid longitude \"([^\"]*)\" and latitude \"([^\"]*)\"$")
    public void iHaveValidLongitudeAndLatitude(String lon, String lat) throws Throwable {
       request = given().queryParam("lon",lon).queryParam("lat",lat);

    }


    @When("^I make a get request to nearest postcode endpoint$")
    public void iMakeAGetRequestToNearestPostcodeEndpoint() throws Throwable {
        response = request.when().get();
        response.then().log().all();
    }


    @Then("^the response status should be \"([^\"]*)\"$")
    public void theResponseStatusShouldBe(String statusCode) throws Throwable {

        response.then().statusCode(Integer.parseInt(statusCode));
    }


    @And("^content type of response received should be in \"([^\"]*)\" format$")
    public void contentTypeOfResponseReceivedShouldBeInFormat(String format) throws Throwable {
        if(format.equals("JSON")){
            response.then().assertThat().contentType(ContentType.JSON).and()
                    .body(matchesJsonSchemaInClasspath("nearest-postcode-schema.json"));
        }
    }
}
