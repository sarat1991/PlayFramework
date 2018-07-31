package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Student {

    @JsonProperty("_id")
    private ObjectId id;
    private String name;
    private String standard;
    private String section;
    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getid() {
        return id.toString();
    }

    public void setid(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getStandard() {
        return standard;
    }

    public String getSection() {
        return section;
    }

    public String getAge() {
        return age;
    }

}
