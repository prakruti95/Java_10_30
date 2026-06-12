package com.demo.MongoDemo;


import org.bson.Document;
import com.mongodb.client.*;

public class ReadData {

    public static void main(String[] args) {

        try(MongoClient client =
            MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase db = client.getDatabase("CollegeDB");

            MongoCollection<Document> students =
                    db.getCollection("students");

            for(Document doc : students.find()) {
                System.out.println(doc.toJson());
            }
        }
    }
}