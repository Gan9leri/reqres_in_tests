package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@DisplayName("API тесты")
@Tag("api")
public class ReqresTests extends TestBase{

    @DisplayName("Проверка шапки ответа")
    @Test
    void getListUsersTest(){
        given().log().all()
                .when()
                .header("x-api-key","reqres-free-v1")
                .get("/users?page=2")
                .then().log().all()
                .statusCode(200)
                .body("page", is(2))
                .body("per_page", is(6))
                .body("total", is(12));
    }
}
