package RESTAssuredImplementation;

import helperClasses.BaseTest;
import helperClasses.ResponsePostCode;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static junit.framework.TestCase.assertTrue;

public class RandomPostCodeTest extends BaseTest {


    @Test
    public void getRandomPostCodeReturnsValidDetails() {
        ResponsePostCode response = ResponsePostCode.fromJson(
                given().
                        when().get(path.formRandomPostcodePath())
                        .then().log().all()
                        .contentType(ContentType.JSON)
                        .body(matchesJsonSchemaInClasspath("postcode-schema.json"))
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract().response().asString()
        );

        Assert.assertEquals(response.getStatus().toString(),("200"));
        assertTrue(!response.getResult().getPostcode().isEmpty());
        assertTrue(!response.getResult().getCodes().getAdminDistrict().isEmpty());

    }


}
