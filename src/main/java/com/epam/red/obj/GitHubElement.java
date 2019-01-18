package com.epam.red.obj;

import java.util.ArrayList;
import java.util.Arrays;

public class GitHubElement {
    private String refClass;
    private String refRepo;
    private ArrayList<String> code;

    public GitHubElement(String refClass, String refRepo, String code) {
        this.refClass = refClass;
        this.refRepo = refRepo;
        this.code = new ArrayList<>(Arrays.asList(code.split(System.lineSeparator())));
    }

    public String getRefClass() {
        return refClass;
    }

    public String getRefRepo() {
        return refRepo;
    }

    public ArrayList<String> getCode() {
        return code;
    }


    public void setRefClass(String refClass) {
        this.refClass = refClass;
    }

    public void setRefRepo(String refRepo) {
        this.refRepo = refRepo;
    }
}
