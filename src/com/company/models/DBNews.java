package com.company.models;

import com.company.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBNews {
    public boolean createNews(News news1)  {
         String SQL = "insert into news(title, text,time) values(?,?,now())";
         try(Connection connection = Database.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
             preparedStatement.setString(1,news1.getTitle());
             preparedStatement.setString(2, news1.getText());
             preparedStatement.executeUpdate();
             System.out.println("Successfully created news" + news1);
             return true;
         }
         catch (SQLException e){
              e.printStackTrace();
              return false;
         }
    }
    public News getNewsById(int id){
          String SQL = "select * from news where id = ?";
          try(Connection connection = Database.connect();
              PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
              preparedStatement.setInt(1,id);
              try(ResultSet resultSet = preparedStatement.executeQuery()) {
                  if (resultSet.next()){
                      News news = new News();
                      news.setId(resultSet.getInt("ID"));
                      news.setText(resultSet.getString("TEXT"));
                      news.setTitle(resultSet.getString("TITLE"));
                      return news;
                  }
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return null;
    }
    public void deleteNewsById(int id){
        String SQL = "delete from news where id = ?";
        try(Connection connection = Database.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
             preparedStatement.setInt(1,id);
             preparedStatement.executeUpdate();
            System.out.println("News deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
