package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.Test;
import pages.BaseReport;

import static org.junit.Assert.assertEquals;

public class DataManagementRESTTest extends BaseReport {

    @Test
    //создание полигона с самопересечением, не должен сохранить.
    public void selfIntersectionPolygon() throws Exception{
        String url = "https://egiptest.mos.ru/egip/layers/15638420/features";
        JtwigTemplate templateBody = JtwigTemplate.classpathTemplate("selfIntersectionPolygon.json");
        JtwigModel model = JtwigModel.newModel();
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                .body(templateBody.render(model))
                .asJson();
        assertEquals("FAIL", jsonResponse.getBody().getObject().get("result"));
        assertEquals("VALIDATION_ERROR", jsonResponse.getBody().getObject().get("errorCode"));
    }
}
