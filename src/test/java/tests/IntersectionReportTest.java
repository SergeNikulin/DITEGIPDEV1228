package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class IntersectionReportTest {

    @Before
    public void authorization() throws Exception {
        Unirest.setDefaultHeader("Content-Type", "application/json");
        String login = "https://egiptest.mos.ru/egip/login";
        String bodyPost = "{  \n" +
                "    \"login\": \"sys\",\n" +
                "    \"password\": \"123456\"\n" +
                "}";

        Unirest.post(login)
                .body(bodyPost)
                .asJson();

    }


    @Test
    public void intersectionReport() throws Exception {
        String url = "https://egiptest.mos.ru/egip/layers/construction/layer-intersection";
        JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("intersectionReport.json");
        JtwigModel model = JtwigModel.newModel()
                .with("layerId", "15640542")
                .with("maskLayerId", "15638420");
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                .body(templateBody.render(model))
                .asJson();
        assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
        assertEquals("CONSTRUCTION_BY_LAYER_INTERSECTION", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
        assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));

        //Получили ID задачи и проверям что она запущена и работает.
        String taskId = jsonResponse.getBody().getObject().getJSONObject("data").get("id").toString();

        String urlTask = "https://egiptest.mos.ru/egip/services/tasks/{Id_task}/result";
        HttpResponse<JsonNode> jsonResponseTask = Unirest.get(urlTask)
                .routeParam("Id_task", taskId)
                .asJson();
        assertEquals("OK", jsonResponseTask.getBody().getObject().get("result"));
        assertEquals("IN_PROGRESS", jsonResponseTask.getBody().getObject().getJSONObject("data").get("status"));
    }

    @After
    public void shutdown() throws IOException {
        Unirest.shutdown();
    }
}


