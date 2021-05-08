package TEST_shorten.Test;

import org.junit.jupiter.api.Test;

import static TEST_shorten.Metods.Metods.*;
import static TEST_shorten.Metods.My_Asserts.assertWithAllure;
import static TEST_shorten.Data.Test_Data.*;
import static TEST_shorten.Data.Test_Data.ERROR2;

public class Tests {
    @Test
    //Тест с корректной ссылкой
    public void test_1() throws Exception {
        String body = create_body(File_test1);
        String result = checking_correct_address(body);
        assertWithAllure(result1, result);
    }


    @Test
    //Тест с  ссылкой на кириллице
    public void test_2() throws Exception {
        String body = create_body(File_test2);
        String result = checking_error_address(body);
        assertWithAllure(ERROR, result);
    }

    @Test
    //Тест с ошибкой в ссылке
    public void test_3() throws Exception {
        String body = create_body(File_test3);
        String result = checking_error_address(body);
        assertWithAllure(ERROR2, result);
    }

    @Test
    //Тест с спецсимволом в ссылке
    public void test_4() throws Exception {
        String body = create_body(File_test4);
        String result = checking_error_address(body);
        assertWithAllure(ERROR2, result);
    }

    @Test
    //Тест ссылка с пробелом(Баг?)
    public void test_5() throws Exception {
        String body = create_body(File_test5);
        String result = checking_error_address(body);
        assertWithAllure(ERROR2, result);
    }

    @Test
    //Тест с отправкой пустого запроса
    public void test_6() throws Exception {
        String body = create_body(File_test6);
        String result = checking_error_address(body);
        assertWithAllure(ERROR3, result);
    }
}
