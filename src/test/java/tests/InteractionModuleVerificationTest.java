package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.junit.Assert;
import org.junit.Test;
import pages.BaseReport;
import utils.Log;

import static org.junit.Assert.assertEquals;

public class InteractionModuleVerificationTest extends BaseReport {
    @Test
    public void dataConsumerModule() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://egiptest.mos.ru/egip/actuator/health";
            Log.info("Appeal to API on URL.");
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();
            Log.info("Getting an answer.");
            if(!"UP".equals(jsonResponse.getBody().getObject().get("status"))){
                throw new Exception("Status is not equal UP");
            }
            Log.info("Test completed successfully. The Module Verification Data Consumer is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!! Check and restore functionality of the PS ODGD server (restart the service)", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }


    @Test
    public void interactionWithDataProvidersREONIC() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "http://10.127.1.27:6080/arcgis/rest/services/REON_ak_zu/MapServer/0/query";
            Log.info("Appeal to API on URL.");
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();
            Log.info("Getting an answer.");
            if(200!=(jsonResponse.getStatus())){
                throw new Exception("Status code is not equal 200");
            }
            Log.info("Test completed successfully. The Module verification interaction with data providers is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!! Contact technical support for an external system (REON IC)", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }

    @Test
    public void interactionWithDataProvidersODOPM() {
        try {
            Log.info("Test " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is run!");
            String url = "https://op.mos.ru:8080/ehdapi/catalog/get";
            Log.info("Appeal to API on URL.");
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();
            Log.info("Getting an answer.");
            if(200!=(jsonResponse.getStatus())){
                throw new Exception("Status code is not equal 200");
            }
            Log.info("Test completed successfully. The Module verification interaction with data providers is operational.");
        } catch (Exception e) {
            Log.error("TEST FAIL!!!!!! Contact technical support for an external system (ODOPM)", e);
            Assert.fail("TEST FAIL!!!!!!");
        }
    }
}
