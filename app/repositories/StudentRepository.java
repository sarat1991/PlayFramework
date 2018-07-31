package repositories;

import com.google.inject.Inject;
import models.Student;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import uk.co.panaxiom.playjongo.PlayJongo;

public class StudentRepository {
    @Inject
    public PlayJongo jongo;

    public MongoCollection students() {
        return jongo.getCollection("students");
    }

    public Student findById(String id) {
        return students().findOne("{_id: #}", new ObjectId(id)).as(Student.class);
    }

    public void create(Student student){
         students().insert(student);
    }

    public void update(String id, Student student){
         students().update(new ObjectId(id)).with(student);
    }

    public void delete(String id){
        students().remove(new ObjectId(id));
    }


}
