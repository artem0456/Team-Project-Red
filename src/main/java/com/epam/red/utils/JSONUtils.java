package com.epam.red.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.epam.red.utils.LinkUtils.generateValidLink;

public class JSONUtils {


    public static JSONObject getJsonObjectFromFile(String path) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void writeJsonToFile(JSONObject jsonObject, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(jsonObject.toJSONString() + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJsonArrayToFile(JSONArray jsonArray, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(jsonArray.toJSONString() + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeListToFile(List list, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(list.toString() + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getJsonObjFromUrl(String url) throws ParseException {
        Client client = ClientBuilder.newClient();
        String jsonString = "";
        try {
            jsonString = client.target(generateValidLink(url)).request(MediaType.APPLICATION_JSON).get(String.class);
        }
        catch (Exception e){
            getJsonObjFromUrl(url);
        }
        return getJsonObjFromString(jsonString);
    }

    public static JSONArray getJsonArrayFromURL(String url) throws ParseException, InterruptedException {
        Client client = ClientBuilder.newClient();
        String jsonString = "";
        try {
            jsonString = client.target(generateValidLink(url)).request(MediaType.APPLICATION_JSON).get(String.class);
        }
        catch (Exception e){
            getJsonArrayFromURL(url);
        }
        return getJsonArrayFromString(jsonString);
    }

    public static JSONObject getJsonObjFromString(String string) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(string);
        return (JSONObject) obj;
    }

    public static JSONArray getJsonArrayFromString(String string) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(string);
        return (JSONArray) obj;
    }

    public static void writeStringToFile(String links, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(links + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
