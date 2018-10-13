package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostCodeValidationSteps {

    private Response response;
    private RequestSpecification request;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://api.postcodes.io";
        RestAssured.basePath = "/postcodes";
    }

    @Given("^The GET postcode endpoint is up and running$")
    public void thePostcodeEndpointIsAlreadyConfigured() throws Throwable {

        request = given();
    }

    @When("^I input a postcode \"([^\"]*)\"$")
    public void iInputAValidPostcode(String postCode) throws Throwable {

        response = request.when().get("/" + postCode);
        response.then().log().all();
    }

    @Then("^I should get the response status \"([^\"]*)\"$")
    public void iShouldGetTheResponseStatus(String statusCode) throws Throwable {

        response.then().statusCode(Integer.parseInt(statusCode));
    }


    @And("^content type of response should be in \"([^\"]*)\" format$")
    public void contentTypeOfResponseShouldBeInFormat(String format) throws Throwable {
        if(format.equals("JSON")){
            response.then().assertThat().contentType(ContentType.JSON).and()
                    .body(matchesJsonSchemaInClasspath("postcode-schema.json"));
        }
    }

    @And("^the body response should be contain below values$")
    public void theBodyResponseShouldBeContainBelowValues(Map<String,String> responseFields) throws Throwable {

        ValidatableResponse json = response.then();

        for (Map.Entry<String, String> field : responseFields.entrySet()) {

            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }

    }

    @And("^error message is \"([^\"]*)\"$")
    public void errorMessageIs(String error) throws Throwable {
        Assert.assertEquals(response.jsonPath().get("error"),error);

    }
}