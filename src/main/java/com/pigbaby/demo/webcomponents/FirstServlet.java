package com.pigbaby.demo.webcomponents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pigbaby.demo.utils.SourceFile;

import org.springframework.util.ResourceUtils;

/**
 * FirstServlet
 */
@WebServlet(urlPatterns = "/First")
public class FirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // private static final String siteUrl =
    // "http://192.168.105.10:8080/dtwzht/showNewsForSiteControlAction!showNews.action?site=xny_site&news=";
    private static final String siteUrl = "http://192.168.105.10:8080/dtwzht/xny_site_HTML/cslm/2019/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===========doGet====================");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        SourceFile sourceFile = new SourceFile();
        // System.out.println(req.getParameter("url"));
        String id = req.getParameter("newsId");

        // sourceFile.getHtml("http://www.china-cdt.com:80//indexAction.ndo?action=showindex");
        // System.out.println("Visit URL is : " + siteUrl + id + ".html");
        // String html = sourceFile.getHtml(siteUrl + id + ".html");
        String html = sourceFile.getHtml(
                "http://www.china-cdt.com/dtwz/indexAction.ndo?action=showDoc&d=93F333FF-DE5F-DFA4-8191-2A31551F01EA&t=index_news&frontDateStr=2019");
        // System.out.println(html);
        // System.out.println(ResourceUtils.getURL("classpath:").getPath());
        // System.out.println("this servlet is from : " + req.getServletPath());
        File file = new File(ResourceUtils.getURL("classpath:").getPath() + "/test.html");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(html);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("已经OK");
        // out.println(html);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}