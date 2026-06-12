package com.demo.MongoDemo;


import org.bson.Document;
import com.mongodb.client.*;

public class InsertData {

    public static void main(String[] args) {

        try(MongoClient client =
            MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase db = client.getDatabase("CollegeDB");

            MongoCollection<Document> students =
                    db.getCollection("students");

            Document student = new Document("name","Rahul")
                    .append("age",22)
                    .append("course","MCA");

            students.insertOne(student);

            System.out.println("Student Inserted");
        }
    }
}
