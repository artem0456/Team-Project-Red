package com.epam.red.servlet;


import com.epam.red.obj.GitHubElement;
import com.epam.red.utils.SearchUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;


public class GitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletResponse.setContentType("text/html");
        String searchWord = httpServletRequest.getParameter("q");


        SearchUtils SU;
        JSONObject jsonObj = null;
        try {
             SU = new SearchUtils();
             jsonObj = SU.findClass(searchWord, System.getProperty("path"));

        } catch (ParseException | InterruptedException e) {
            e.printStackTrace();
        }
            JSONObject jo;

            ArrayList<GitHubElement> list = new ArrayList<>();
            for (int i = 0; i < jsonObj.size(); i++) {
                jo = (JSONObject) jsonObj.get(i+1);
                list.add(new GitHubElement(jo.get("class_url").toString(),
                        jo.get("repo_url").toString(),
                        jo.get("code").toString()));
            }


            HttpSession session = httpServletRequest.getSession();
            if (list.size() != 0 ) {
                session.setAttribute("list", list);
                httpServletRequest.getRequestDispatcher("/welcome.jsp")
                        .forward(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.sendRedirect("oops.jsp");
            }


    }

}
