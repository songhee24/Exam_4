package com.company;

import com.company.models.DBNews;
import com.company.models.News;

public class Main {
   static DBNews dbNews = new DBNews();
    public static void main(String[] args) {
        News news = new News(
                "Загрязнение воздуха в Бишкеке.",
                "в районе улиц Бейшеналиевой/Токтогула. Уровень загрязнения превышен в 3,34 раза: PM2.5 среднесуточный — 117 мкг/м³, на момент измерения — 346 мкг/м³;"

        );
//        addNews(news);
//          printNews(news);
//        dbNews.deleteNewsById(1);
    }

       static void addNews(News news){
             if (dbNews.createNews(news)) System.out.println("success added news");
             else System.out.println("Failed");
       }

       static void printNews(News news){
             news = dbNews.getNewsById(1);
             System.out.println(news);
       }


}
