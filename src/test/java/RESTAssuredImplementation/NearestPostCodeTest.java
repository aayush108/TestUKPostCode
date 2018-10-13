package RESTAssuredImplementation;

import helperClasses.BaseTest;
import helperClasses.ResponseNearestPostCode;
import helperClasses.Result;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NearestPostCodeTest extends BaseTest {

    @Test
    public void getNearestPostCodesShouldReturnCorrectPostCodes() {
        ResponseNearestPostCode response = ResponseNearestPostCode.fromJson(
                given().
                        queryParam("lon","-1.45206389524253").
                        queryParam("lat", "53.3751367373779").
                        when().get(path.formNearestPostcodePath() )
                        .then().log().all()
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(ContentType.JSON)
                        .extract().response().asString()
        );
        List<Result> results = response.getResult();

//        for (helperClasses.Result field : results)
//        {
//            if (field.getPostcode().matches("S2 2SF")){
//                System.out.println("Post code is found");
//                break;
//            }
//            else {  System.out.println("Post code is not found");  }
//        }
        Assert.assertEquals(response.getResult().size(),7);

//        assertThat( results, contains(
//                hasProperty("postcode", is("S2 5HR")),
//                hasProperty("quality", is("1"))
//        ));

    }


}
