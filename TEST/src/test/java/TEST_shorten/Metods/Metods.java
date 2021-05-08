package TEST_shorten.Metods;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static TEST_shorten.Data.Test_Data.URL_Service;
import static io.restassured.RestAssured.given;

@Slf4j
public class Metods {
    static Logger logger = LoggerFactory.getLogger("SLF4J");

    //Метод для считывания ссылки и формирования тела запроса
    public static String create_body(String path) throws Exception {
        logger.info(String.format("Считываем ссылку из файла и создаем тело для запроса"));
        BufferedReader sourcePath_br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "CP866"));
        String message = org.apache.commons.io.IOUtils.toString(sourcePath_br);
        String body = "{\n" +
                "  \"url\": \"" + message + "\"\n" +
                "}";
        return body;
    }

    //Проверка отработки сервиса при корректной ссылке
    public static String checking_correct_address(String body) throws Exception {
        logger.info(String.format("Отправляем запрос к API"));
        JsonPath response = given().accept(ContentType.JSON).contentType(ContentType.JSON).given().baseUri(URL_Service).body(body).when().post().then().assertThat().statusCode(200).extract().jsonPath();
        String actual_fullName = response.getString("result_url");
        return actual_fullName;
    }
    //Проверка отработки сервиса при ошибочной ссылке
    public static String checking_error_address(String body) throws Exception {
        logger.info(String.format("Отправляем запрос к API"));
        JsonPath response = given().accept(ContentType.JSON).contentType(ContentType.JSON).given().baseUri(URL_Service).body(body).when().post().then().assertThat().statusCode(400).extract().jsonPath();
        String actual_fullName = response.getString("error");
        return actual_fullName;
    }

}
