package cn.baiyu.tumoserver;

import org.jsoup.Jsoup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TumoServerApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @org.junit.Test
    public void split() {
        String html = "<p>接着上一篇文章：<a href=\"http://baiyu.xyz/\">SpringBoot开发</a>，";
        String s = Jsoup.parse(html).text();
        System.out.println(s);
    }

    @Test
    public void subStringList() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        List subList = list.subList(0, 2);
        logger.info("list={}", subList);

        int i = 3;
        int ii = 2;

        System.out.println(Math.round((double) i / (double) ii));
    }

}
