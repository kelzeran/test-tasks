package Test_randomUser.Metods;

import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertTrue;

public class Asserts {
    static Logger logger = LoggerFactory.getLogger("SLF4J");
    public static void assert_response(JsonPath response) throws Exception {
        //проверяем, что все массивы заполнены
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве results "));
        String actual = response.getString("results");
        assertTrue(actual.contains("gender"));
        assertTrue(actual.contains("nat"));
        assertTrue(actual.contains("dob"));
        assertTrue(actual.contains("name"));
        assertTrue(actual.contains("registered"));
        assertTrue(actual.contains("location"));
        assertTrue(actual.contains("postcode"));
        assertTrue(actual.contains("coordinates"));
        assertTrue(actual.contains("id"));
        assertTrue(actual.contains("login"));
        assertTrue(actual.contains("cell"));
        assertTrue(actual.contains("email"));
        assertTrue(actual.contains("picture"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве dob "));
        actual = response.getString("results[0].dob");
        assertTrue(actual.contains("date"));
        assertTrue(actual.contains("age"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве name "));
        actual = response.getString("results[0].name");
        assertTrue(actual.contains("last"));
        assertTrue(actual.contains("title"));
        assertTrue(actual.contains("first"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве registered "));
        actual = response.getString("results[0].registered");
        assertTrue(actual.contains("date"));
        assertTrue(actual.contains("age"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве location "));
        actual = response.getString("results[0].location");
        assertTrue(actual.contains("country"));
        assertTrue(actual.contains("city"));
        assertTrue(actual.contains("street"));
        assertTrue(actual.contains("timezone"));
        assertTrue(actual.contains("postcode"));
        assertTrue(actual.contains("coordinates"));
        assertTrue(actual.contains("state"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве street "));
        actual = response.getString("results[0].location.street");
        assertTrue(actual.contains("number"));
        assertTrue(actual.contains("name"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве timezone "));
        actual = response.getString("results[0].location.timezone");
        assertTrue(actual.contains("offset"));
        assertTrue(actual.contains("description"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве coordinates "));
        actual = response.getString("results[0].location.coordinates");
        assertTrue(actual.contains("latitude"));
        assertTrue(actual.contains("longitude"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве id "));
        actual = response.getString("results");
        assertTrue(actual.contains("name"));
        assertTrue(actual.contains("value"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве login"));
        actual = response.getString("results");
        assertTrue(actual.contains("sha1:"));
        assertTrue(actual.contains("password"));
        assertTrue(actual.contains("salt:"));
        assertTrue(actual.contains("sha256:"));
        assertTrue(actual.contains("uuid"));
        assertTrue(actual.contains("username:"));
        assertTrue(actual.contains("md5:"));
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве picture"));
        actual = response.getString("results.picture[0]");
        assertTrue(actual.contains("thumbnail:"));
        assertTrue(actual.contains("medium"));
        assertTrue(actual.contains("large:"));
        assertTrue(actual.contains("medium:"));
        logger.info(String.format("Все массивы содержат нужные ключи и они указаны согласно ТЗ"));
    }
    public static void assertWithAllure(Object expected, Object actual, Object... others) {
        logger.info(String.format("Ожидаемый результат %s - фактический результат %s", expected, actual));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
        if (others.length % 2 != 0) {
            throw new RuntimeException("Количество аргументов для сравнения не четное");
        }
        for (int i = 0; i < others.length; i++) {
            if (i % 2 != 0) continue;
            softAssert.assertEquals(others[i], others[i + 1]);
        }
        softAssert.assertAll();
        logger.info(String.format("Ответ соответсвует ожиданию. Тест успешен."));
    }
    public static void assert_responseParametrs(JsonPath response,String path,String Parametrs) throws Exception {
        logger.info(String.format("Проверяем, что в полученном ответе установлено значение, согласной переданному параметру"));
        String actual = response.getString(path);
        assertWithAllure(actual,Parametrs);

    }
    public static void assert_response_reduction(JsonPath response) throws Exception {
        //проверяем, что все массивы заполнены
        logger.info(String.format("Проверяем наличие и корректность ключей в массиве results "));
        String actual = response.getString("results");
        assertTrue(actual.contains("gender"));
        assertTrue(actual.contains("nat"));
        assertTrue(actual.contains("name"));
        String[]list = actual.split(",");
        logger.info(String.format("Убеждаемся, что длинна массива соответсвует ожидаемой длинне при заданном параметре"));
        int i = list.length;
        assertWithAllure(i,5);
        System.out.println(actual);
    }
}
