package RESTAssuredImplementation;

import helperClasses.BaseTest;
import helperClasses.ResponsePostCode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class PostCodeLookUpTest extends BaseTest {

    @Test
    public void validPostCodeShouldReturn200() {
        String postCode = "s22sf";
        ResponsePostCode response = ResponsePostCode.fromJson(
                given().
                        when().get(path.formSinglePostcodePath(postCode))
                        .then().log().all()
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract().response().asString()
        );

        Assert.assertEquals(response.getResult().getCountry(),"England");
        Assert.assertEquals(response.getResult().getAdminWard(),"Manor Castle");
        Assert.assertEquals(response.getResult().getCodes().getParish(),"E43000173");

    }

    @Test
    public void invalidPostCodeShouldReturn400() {
        String postCode = "random";
        Response response =
                given().
                        when().get(path.formSinglePostcodePath(postCode))
                        .then().log().all()
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .statusCode(HttpStatus.SC_NOT_FOUND)
                        .contentType(ContentType.JSON)
                        .extract().response();

        Assert.assertEquals(response.path("error").toString(), "Invalid postcode");

    }
}