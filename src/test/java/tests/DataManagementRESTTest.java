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

public class DataManagementRESTTest extends BaseReport {
    @Ignore
    @Test
    //создание полигона с самопересечением, не должен сохранить.
    public void selfIntersectionPolygon() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            Log.info("создание полигона с самопересечением, не должен сохранится объект.");
            String url = "https://egiptest.mos.ru/egip/layers/15638420/features";
            Log.info("Appeal to API on URL.");
            JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("selfIntersectionPolygon.json");
            JtwigModel model = JtwigModel.newModel();
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .body(templateBody.render(model))
                    .asJson();
            Log.info("Getting an answer.");
            assertEquals("FAIL", jsonResponse.getBody().getObject().get("result"));
            assertEquals("VALIDATION_ERROR", jsonResponse.getBody().getObject().get("code"));
            Log.info("TEST OK!!!");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!!", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }
}
