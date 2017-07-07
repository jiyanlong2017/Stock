/*
package com.hyhy.xxx.utils;

import com.hyhy.xxx.model.News;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

*/
/**
 * 页面静态化处理工具
 *//*

public class HTMLUtils {

    public static String[] getStaticHtml(String title, String article, List<News> xiangguan, String keywords, String description) throws IOException {

        Document document = Jsoup.parse("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "<meta name=\"keywords\" content=\"\"/>\n" +
                "    <meta name=\"derscription\" content=\"\" />" +
                "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\"/>\n" +
                "    <title></title>\n" +
                "    <link rel=\"stylesheet\" href=\"../../../../css/mui.min.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"../../../../css/news.css\">\n" +
                "    <script type=\"text/javascript\" src=\"../../../../js/mui.min.js\"></script>\n" +
                "</head>\n" +
                "<script type=\"text/javascript\">\n" +
                "    */
/* 创建于 2016-04-12*//*
\n" +
                "    var cpro_id = \"u2599250\";\n" +
                "</script>\n" +
                "<script src=\"http://cpro.baidustatic.com/cpro/ui/mi.js\" type=\"text/javascript\"></script>\n"+
                "<body>\n" +
                "<header class='m-header'>" +
                "<h3 class=\"m-title\"></h3>\n" +
                "<p class=\"m-date\"></p>\n" +
                "</header>" +
                "<div class=\"m-article mui-h5\">\n" +
                "</div>\n" +
                "  <div class='m-read-m'><span class=\"mui-h5\" id=\"m-read\">阅读</span><span id=\"m-count\"></span></div>" +
                "<div class=\"m-xiangguan\"> \n" +
                "   <p id=\"jingcai\">更多精彩</p>\n" +
                "   <ul class=\"mui-table-view\" id='x-ul'>\n" +

                "   </ul>\n" +
                "  </div> " +
                "<div class=\"m-ad\">\n" +
                "      <p style=\"text-align: center; margin-bottom: 0\">推广</p>\n" +
                "      <div class=\"ad-inner\">" +
                "   <script type=\"text/javascript\">\n" +
                "    */
/*20:5 创建于 2016-04-12*//*
\n" +
                "    var cpro_id = \"u2599290\";\n" +
                "</script>\n" +
                "<script src=\"http://cpro.baidustatic.com/cpro/ui/cm.js\" type=\"text/javascript\"></script>\n"+
                "</div>\n" +
                "  </div>" +
                "<script type=\"text/javascript\" >\n" +
                "      (function(){\n" +
                "          var url = window.location.href;\n" +
                "          var a = url.lastIndexOf(\"/\");\n" +
                "          var b = url.lastIndexOf(\".\");\n" +
                "          var uuid = url.substring(a+1, b);\n" +
                "\n" +
                "          mui.get(\"/news/count?id=\"+ uuid, function (value){\n" +
                "              document.getElementById(\"m-count\").innerText = value;" +
                "          });\n" +
                "      })();\n" +
                "\n" +
                "\n" +
                "  </script>" +
                "</body>\n" +
                "</html>\n");

        document.getElementsByClass("m-title").get(0).text(title);
        document.getElementsByClass("m-date").get(0).text(DateUtils.getDate());

        document.getElementsByClass("m-article").get(0).html(article);

        if (xiangguan.size() == 0) {
            document.getElementsByClass("m-xiangguan").get(0).remove();
        } else {

            for (News news : xiangguan) {
                Element element = document.getElementById("x-ul");
                element.append("    <li class=\"mui-table-view-cell mui-media\">\n" +
                        "     <a href=\""+ news.getUrl() +"\">\n" +
                        "      <img class=\"mui-media-object mui-pull-right\" src=\" " + news.getImg() + "\" id='x-img'>\n" +
                        "      <div class=\"mui-media-body\">\n" +
                        "       <p class='x-name mui-ellipsis-2'>" + news.getTitle() + "</p>\n" +
                        "      </div>\n" +
                        "     </a>\n" +
                        "    </li>\n");
            }
        }
        Elements meats = document.getElementsByTag("meta");
        for (Element e : meats) {
            if (StringUtils.equalsIgnoreCase(e.attr("name"), "keywords")) {
                e.attr("content", keywords);
            } else if (StringUtils.equalsIgnoreCase(e.attr("name"), "description")) {
                e.attr("content", description);
            }
        }
        document.getElementsByTag("title").get(0).text(title);

        String d = document.toString();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        StringBuffer dir = new StringBuffer();
        String year = DateUtils.getYear();
        String month = DateUtils.getMonth();
        String day = DateUtils.getDay();
        String uuid = UUID.randomUUID().toString();
        dir.append(request.getRealPath("/")).append("news/").append(year)
                .append("/").append(month)
                .append("/").append(day);


        File fileDir = new File(dir.toString());
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File file = new File(fileDir, uuid + ".html");
        FileOutputStream out = new FileOutputStream(file);

        IOUtils.write(d, out, "utf-8");
        String u = "/news/" + year + "/" + month + "/" + day + "/" + uuid + ".html";


        return new String[]{u, uuid};
    }
}
*/
