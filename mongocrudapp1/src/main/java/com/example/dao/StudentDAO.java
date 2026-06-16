package com.example.dao;

import com.example.model.Student;
import com.mongodb.client.*;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private MongoCollection<Document> collection =
            MongoUtil.getDatabase().getCollection("students");

    // CREATE
    public void save(Student student) {

        Document doc = new Document()
                .append("name", student.getName())
                .append("email", student.getEmail());

        collection.insertOne(doc);
    }

    // READ
    public List<Student> getAll() {

        List<Student> list = new ArrayList<>();

        FindIterable<Document> docs = collection.find();

        for(Document doc : docs) {

            Student s = new Student();

            s.setId(doc.getObjectId("_id").toString());
            s.setName(doc.getString("name"));
            s.setEmail(doc.getString("email"));

            list.add(s);
        }

        return list;
    }
    
    public Student getById(String id) {

        Document doc = collection.find(
                new Document("_id", new ObjectId(id))
        ).first();

        if(doc == null) {
            return null;
        }

        Student s = new Student();

        s.setId(doc.getObjectId("_id").toString());
        s.setName(doc.getString("name"));
        s.setEmail(doc.getString("email"));

        return s;
    }

    // UPDATE
    public void update(Student student) {

        collection.updateOne(
                new Document("_id",
                        new ObjectId(student.getId())),
                new Document("$set",
                        new Document("name",
                                student.getName())
                                .append("email",
                                        student.getEmail()))
        );
    }

    // DELETE
    public void delete(String id) {

        collection.deleteOne(
                new Document("_id",
                        new ObjectId(id))
        );
    }
    
}