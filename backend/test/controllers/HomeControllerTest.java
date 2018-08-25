package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;
import play.libs.Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import static play.test.Helpers.route;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void testCreateReport() {
        HashMap<String, String> data = new java.util.HashMap<>();
        data.put("status","WAITING_FOR_CUSTOMER");
        data.put("email","test@gmail.com");
        data.put("fraudScore","0");
        data.put("policeNr","5");
        data.put("damageDate","50505050");
        data.put("offerExists","true");
        data.put("costs","5000");
        data.put("selfEstimated","false");
        data.put("billExists","false");

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(PUT)
                .uri("/DamageReport")
                .bodyForm(data);
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("1", ((play.http.HttpEntity.Strict)result.body()).data().utf8String());
    }

    @Test
    public void testCreateJSONReport() {
        JsonNode json = Json.parse("{\"status\" : \"WAITING_FOR_CUSTOMER\"," +
                "\"email\" : \"test@gmail.com\"," +
                "\"fraudScore\" : \"0\"," +
                "\"policeNr\" : \"5\"," +
                "\"damageDate\" : \"50505050\"," +
                "\"offerExists\" : \"true\"," +
                "\"selfEstimated\" : \"false\"," +
                "\"billExists\" : \"false\"}");
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(PUT)
                .uri("/DamageReport")
                .bodyJson(json);
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("1", ((play.http.HttpEntity.Strict)result.body()).data().utf8String());
    }

    @Test
    public void testEditReport() {
        testCreateReport();
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/DamageReport/1");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        ObjectNode json = (ObjectNode)Json.parse(((play.http.HttpEntity.Strict)result.body()).data().utf8String());
        json.put("fraudScore", "20");

        request = new Http.RequestBuilder()
                .method(POST)
                .uri("/DamageReport")
                .bodyJson(json);
        result = route(app, request);
        assertEquals(OK, result.status());

        request = new Http.RequestBuilder()
                .method(GET)
                .uri("/DamageReport/1");
        result = route(app, request);
        assertEquals(OK, result.status());
        JsonNode jnode = Json.parse(((play.http.HttpEntity.Strict)result.body()).data().utf8String());
        System.out.println(((play.http.HttpEntity.Strict)result.body()).data().utf8String());
        assertEquals("20.0", jnode.findPath("fraudScore").toString());
    }

    @Test
    public void testEvent() {
        testCreateReport();
        HashMap<String, String> data = new HashMap<>();
        data.put("type", "CALL");
        data.put("text", "Sie haben einen Schaden?");
        data.put("report-id", "1");

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(PUT)
                .uri("/Event")
                .bodyForm(data);
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("1", ((play.http.HttpEntity.Strict)result.body()).data().utf8String());

        request = new Http.RequestBuilder()
                .method(GET)
                .uri("/Event/1");
        result = route(app, request);
        JsonNode json = Json.parse(((play.http.HttpEntity.Strict)result.body()).data().utf8String());
        assertEquals("CALL", json.findPath("type").textValue());
    }
}
