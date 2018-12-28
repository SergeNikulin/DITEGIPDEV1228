package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.BaseReport;
import utils.Log;


import static org.junit.Assert.assertEquals;


public class ReportTest extends BaseReport {
    @Ignore
    @Test
    public void intersectionReport() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://egiptest.mos.ru/egip/layers/construction/layer-intersection";
            Log.info("Appeal to API on URL.");
            JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("intersectionReport.json");
            JtwigModel model = JtwigModel.newModel()
                    .with("layerId", "15640542")
                    .with("maskLayerId", "15638420");
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .body(templateBody.render(model))
                    .asJson();
            Log.info("Getting an answer.");
            assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
            assertEquals("CONSTRUCTION_BY_LAYER_INTERSECTION", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
            assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));

            //Получили ID задачи и проверям что она запущена и работает.
            String taskId = jsonResponse.getBody().getObject().getJSONObject("data").get("id").toString();

            Thread.sleep(2000);
            Log.info("Checking the result of the task");
            String urlTask = "http://egiptest.mos.ru/egip/services/tasks/{Id_task}/result";
            HttpResponse<JsonNode> jsonResponseTask = Unirest.get(urlTask)
                    .routeParam("Id_task", taskId)
                    .asJson();
            assertEquals("OK", jsonResponseTask.getBody().getObject().get("result"));
            assertEquals("IN_PROGRESS", jsonResponseTask.getBody().getObject().getJSONObject("data").get("status"));
            Log.info("TEST IS OK!!!");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Ignore
    @Test
    public void reportOnTheObject() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://egiptest.mos.ru/egip/services/reports/feature";
            Log.info("Appeal to API on URL.");
            JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("reportOnTheObject.json");
            JtwigModel model = JtwigModel.newModel()
                    .with("layerId", "15638420")
                    .with("featureId", "15638047");
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .body(templateBody.render(model))
                    .asJson();
            Log.info("Getting an answer.");
            assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
            assertEquals("FEATURE_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
            assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));

            //Получили ID задачи и проверям что она запущена и работает.
            String taskId = jsonResponse.getBody().getObject().getJSONObject("data").get("id").toString();
            Thread.sleep(3000);
            Log.info("Checking the result of the task");
            String urlTask = "http://egiptest.mos.ru/egip/services/tasks/{Id_task}/result";
            HttpResponse<JsonNode> jsonResponseTask = Unirest.get(urlTask)
                    .routeParam("Id_task", taskId)
                    .asJson();
            assertEquals("OK", jsonResponseTask.getBody().getObject().get("result"));
            assertEquals("ACCOMPLISHED", jsonResponseTask.getBody().getObject().getJSONObject("data").get("status"));
            Log.info("TEST IS OK!!!");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Ignore
    @Test
    public void metricsReports() throws Exception {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://egiptest.mos.ru/egip/services/reports/metrics";
            Log.info("Appeal to API on URL.");
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
            Log.info("Getting an answer.");
            assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
            assertEquals("METRICS_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
            assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));

            //Получили ID задачи и проверям что она запущена и работает.
            String taskId = jsonResponse.getBody().getObject().getJSONObject("data").get("id").toString();
            Thread.sleep(2000);
            Log.info("Checking the result of the task");
            String urlTask = "http://egiptest.mos.ru/egip/services/tasks/{Id_task}/result";
            HttpResponse<JsonNode> jsonResponseTask = Unirest.get(urlTask)
                    .routeParam("Id_task", taskId)
                    .asJson();
            assertEquals("OK", jsonResponseTask.getBody().getObject().get("result"));
            assertEquals("FAILED", jsonResponseTask.getBody().getObject().getJSONObject("data").get("status"));
            Log.info("TEST IS OK!!!");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Ignore
    @Test
    public void bufferReports() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://egiptest.mos.ru/egip/services/reports/buffer";
            Log.info("Appeal to API on URL.");
            JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("bufferReports.json");
            JtwigModel model = JtwigModel.newModel()
                    .with("layerId", "15641284");
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .body(templateBody.render(model))
                    .asJson();
            Log.info("Getting an answer.");
            Log.info("Checking the result of the task");
            assertEquals("OK", jsonResponse.getBody().getObject().get("result"));
            assertEquals("BUFFER_REPORT", jsonResponse.getBody().getObject().getJSONObject("data").get("type"));
            assertEquals("SCHEDULED", jsonResponse.getBody().getObject().getJSONObject("data").get("status"));
            Log.info("TEST IS OK!!!");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }
}


