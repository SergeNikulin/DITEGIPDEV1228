package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.Ignore;
import org.junit.Test;
import pages.BaseReport;

import static org.junit.Assert.assertEquals;


public class ReportTest extends BaseReport {

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

    @Test
    public void reportOnTheObject() throws Exception {
        String url = "https://egiptest.mos.ru/egip/services/reports/feature";
        JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("reportOnTheObject.json");
        JtwigModel model = JtwigModel.newModel()
                .with("layerId", "15638420")
                .with("featureId", "15638047");
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                .body(templateBody.render(model))
                .asJson();
        assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
        assertEquals("FEATURE_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
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

    @Test
    public void metricsReports() throws Exception {
        String url = "https://egiptest.mos.ru/egip/services/reports/metrics";
        JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("metricsReports.json");
        JtwigModel model = JtwigModel.newModel()
                .with("layerId", "15638420")
                .with("MetricType", "AREA")
                .with("MetricUnit", "SQ_KILOMETER")
                .with("MetricType1", "PERIMETER")
                .with("MetricUnit1", "KILOMETER");
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                .body(templateBody.render(model))
                .asJson();
        assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
        assertEquals("METRICS_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
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

@Test
    public void bufferReports() throws Exception{
    String url = "https://egiptest.mos.ru/egip/services/reports/buffer";
    JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("bufferReports.json");
    JtwigModel model = JtwigModel.newModel()
            .with("layerId", "15638420");
    HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
            .body(templateBody.render(model))
            .asJson();
    assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
    assertEquals("BUFFER_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
    assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));
}
}


