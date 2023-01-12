import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class Praktikum_1 {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserName() {

        given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzMzMTc4ZmQzYjg2YTAwM2Q2N2QyYWQiLCJpYXQiOjE2NzM0NTIxNzgsImV4cCI6MTY3NDA1Njk3OH0.ZZcq2Welp1o2uDgwtS5ZHqAgwRtNiihNgIZPShBbH5s")
                .get("/api/users/me")
                .then().assertThat().body("data.name", equalTo("здесь_укажи_имя_своего_пользователя"));
    }
}
