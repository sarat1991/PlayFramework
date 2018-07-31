package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Message;
import models.Student;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.StudentRepository;

import javax.inject.Inject;

public class StudentController extends Controller {

    HttpExecution httpExecution;

    private StudentRepository students;

    @Inject
    public StudentController(HttpExecution httpExecution, StudentRepository students){
        this.httpExecution = httpExecution;
        this.students = students;
    }

    public Result create(){
        JsonNode json = request().body().asJson();
        final Student student = Json.fromJson(json,Student.class);
        students.create(student);
        return ok("Entered Created");
    }

    public Result show(String id){
        students.findById(id);
        Student student = students.findById(id);
        JsonNode json;
        if(student == null)
            json = Json.toJson(new Message("Not found"));
        else
            json = Json.toJson(student);
        return ok(json);
    }

    public Result update(String id){
        JsonNode json = request().body().asJson();
        final Student student = Json.fromJson(json, Student.class);
        students.update(id, student);
        return ok(json);
    }

    public Result delete(String id){
        students.delete(id);
        return ok(Json.toJson("deleted successfully"));
    }

}
