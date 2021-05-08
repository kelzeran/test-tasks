package TEST_shorten.Metods;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

@Slf4j
public class My_Asserts {

    static Logger logger = LoggerFactory.getLogger("SLF4J");

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

}
