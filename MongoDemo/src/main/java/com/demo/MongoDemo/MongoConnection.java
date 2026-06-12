package com.demo.MongoDemo;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    public static void main(String[] args) {

        String uri = "mongodb://localhost:27017";

        try (MongoClient client = MongoClients.create(uri)) {

            MongoDatabase db = client.getDatabase("CollegeDB");

            System.out.println("Connected Successfully");
            System.out.println("Database Name : " + db.getName());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}