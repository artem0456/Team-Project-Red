package com.epam.red.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class SearchUtils {

    public JSONObject findClass(String word, String path) throws ParseException, InterruptedException, IOException {
        JSONObject classFound = new JSONObject();
        JSONObject result = new JSONObject();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        while (reader.ready()) {
            JSONObject tempJson = JSONUtils.getJsonObjFromString(reader.readLine());
            if (tempJson.get("class").toString().equalsIgnoreCase(word)) {
                classFound = tempJson;
                break;
            }
        }

        if (classFound.isEmpty()) {
            return classFound;
        }

        String[] links = LinkUtils.operate(classFound.get("links").toString().replaceFirst("\"", ""));
        int counter = 1;
        for (String link : links) {
            JSONObject element = new JSONObject();
            String gitRawLink = LinkUtils.formatLink(link);
            String code = SearchUtils.searchCode(gitRawLink, word);
            String gitLink = LinkUtils.replaceRawWithGithub(gitRawLink);
            String repo_url = LinkUtils.getLinkOnRepo(gitLink);
            String class_url = LinkUtils.getLinkOnClass(gitLink, repo_url);
            element.put("repo_url", repo_url);
            element.put("class_url", class_url);
            element.put("code", code);
            result.put(counter, element);
            counter++;
            if (counter > 50) {
                break;
            }
        }
        return result;
    }

    private static String searchCode(String link, String className) throws IOException {
        URL url = new URL(link);
        File file = new File("resources/Test.java");
        boolean found = false;
        int counter = 1;
        StringBuilder code = new StringBuilder();
        FileUtils.copyURLToFile(url, file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (StringUtils.containsIgnoreCase(line, ("new " + className)) && !found) {
                    found = true;
                }
                if (found && counter <= 10) {
                    code.append(line);
                    code.append(System.lineSeparator());
                    counter++;
                }
            }
        }
        return code.toString();
    }
}
