package models;

import play.data.validation.Constraints;

public class Company extends BaseModel {
    @Constraints.Required
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

