package controllers;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class APITest extends FunctionalTest {

	@Test
    public void testIndex() {
        Response response = GET("/api");
        assertIsOk(response);
        String content = "{\"MEGA_SENA\":\"http://localhost/api/MEGA_SENA\"}";
		assertContentEquals(content, response);
    }
	
	@Test
	public void testMegaSena() {
		Response response = GET("/api/MEGA_SENA");
		assertIsOk(response);
		String pattern = "\\{\"number\":\\d{4},\"result\":\\[\\{\"number\":\\d{1,2}\\}\\,\\{\"number\":\\d{1,2}\\}\\,\\{\"number\":\\d{1,2}\\}\\,\\{\"number\":\\d{1,2}\\}\\,\\{\"number\":\\d{1,2}\\}\\,\\{\"number\":\\d{1,2}\\}\\]\\,\"lotteryType\":\"MEGA_SENA\"\\}";
		assertContentMatch(pattern, response);
	}
}