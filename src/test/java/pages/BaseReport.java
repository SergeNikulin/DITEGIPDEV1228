package pages;

import com.mashape.unirest.http.Unirest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.IOException;

public class BaseReport {
    @Before
    public void authorization() throws Exception {
        Unirest.setDefaultHeader("Content-Type", "application/json");
        String login = "http://egiptest.mos.ru/egip/login";
        String bodyPost = "{  \n" +
                "    \"login\": \"sys\",\n" +
                "    \"password\": \"!23456QWEqwe\"\n" +
                "}";

        Unirest.post(login)
                .body(bodyPost)
                .asJson();

    }

    @AfterClass
    public static void shutdown() throws Exception {
        Unirest.shutdown();
    }
}
