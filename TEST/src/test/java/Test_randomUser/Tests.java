package Test_randomUser;


import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static Test_randomUser.Metods.Asserts.*;
import static Test_randomUser.Metods.Metods.*;


public class Tests {
    //Отправка запроса без дополнительных параметров
   @Test
    public  void test1() throws Exception{
        JsonPath response = get_randomUser_noParams();
       assert_response(response);

    }
    //Отправка запроса с одним доп.параметром(например пол)
    @Test
    public  void test2() throws Exception{
        JsonPath response = get_randomUser_1Parametrs("gender","female");
        assert_response(response);
        assert_responseParametrs(response,"results[0].gender","female");
    }
    //Отправка запроса с двумя доп.параметром(например пол и национальность)
    @Test
    public  void test3() throws Exception{
        JsonPath response = get_randomUser_2Parametrs("gender","female","nat","GB");
        assert_response(response);
        assert_responseParametrs(response,"results[0].gender","female");
        assert_responseParametrs(response,"results[0].nat","GB");
    }
    //Проверка исключения полей
    @Test
    public  void test4() throws Exception{
        JsonPath response = get_randomUser_1Parametrs("inc","gender,name,nat");
        assert_response_reduction(response);
    }
}
