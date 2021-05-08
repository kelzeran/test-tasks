package Test_randomUser.Metods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static Test_randomUser.Data.Test_data.URL_Service;


public class Metods {
    static Logger logger = LoggerFactory.getLogger("SLF4J");

    public static JsonPath get_randomUser_noParams() throws Exception {
        logger.info(String.format("Отправляем запрос к методу"));
        JsonPath response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).given().baseUri(URL_Service).when().get().then().assertThat().statusCode(200).extract().jsonPath();
        System.out.println(response);
        return response;
    }


    public static JsonPath get_randomUser_1Parametrs(String param,String meaning) throws Exception {
        logger.info(String.format("Отправляем запрос к методу"));
        JsonPath response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).given().baseUri(URL_Service).when().queryParam(param, meaning).get().then().assertThat().statusCode(200).extract().jsonPath();
        System.out.println(response);
        return response;
    }
    public static JsonPath get_randomUser_2Parametrs(String param,String meaning,String param2,String meaning2) throws Exception {
        logger.info(String.format("Отправляем запрос к методу"));
        JsonPath response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).given().baseUri(URL_Service).when().queryParam(param, meaning).queryParam(param2, meaning2).get().then().assertThat().statusCode(200).extract().jsonPath();
        System.out.println(response);
        return response;
    }


}

