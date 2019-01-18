package com.epam.red.utils;

import java.util.ArrayList;
import java.util.Random;

public class LinkUtils {

    public static String urlStringFormater(String wrongURL) {
        return wrongURL.replace("\\", "");
    }

    public static String getLinkOnRepo(String link) {
        String repoLink;
        int index = ordinalIndexOf(link, "/", 5);
        repoLink = link.substring(0, index);
        return repoLink;
    }

    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }

    public static String formatLink(String link) {
        String result = link.substring(1, link.length() - 1).replaceAll("\"", "");
        return urlStringFormater(result);
    }

    public static String replaceRawWithGithub(String link) {
        return link.replaceFirst("raw.githubusercontent", "github");
    }

    public static String getLinkOnClass(String link, String linkOnRepo) {
        String classLink;
        classLink = link.replace(linkOnRepo, linkOnRepo + "/blob");
        return classLink;
    }

    public static String[] operate(String links) {
        return links.split(",");
    }

    public static String generateValidLink(String url) {
        ArrayList<String> id = new ArrayList<>();
        id.add("client_id=cec5b377e98f24d071a5&client_secret=c4df37cb623cf279896ea89a76d4b2864aa9bd49");
        id.add("client_id=cbf6b7b6aba97ac02a15&client_secret=c67a954308a34253806f60310d1446b0850721a0");
        id.add("client_id=33e4eb7899ad7a11b917&client_secret=d1a770462f1efaa9ad973d7fd2c96fe988e0b1a9");
        id.add("client_id=a315d04d1e1009ca5201&client_secret=77d00c2c7cd596b83bbff9f0a70e2e729a141966");
        id.add("client_id=95da0f1c58629b1d8bac&client_secret=f2fa832218cc922b8a9666c8a93623c6ce309b60");
        Random rand = new Random();
        String link;
        int index = rand.nextInt(5);
        if (url.endsWith("/")) {
            link = url + "?" + id.get(index);
        } else {
            link = url + "&" + id.get(index);
        }
        return link;
    }
}
