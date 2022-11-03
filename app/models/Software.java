package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Software extends BaseModel {
    @Constraints.Required
    private String name;

    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date introduced;

    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date discontinued;

    @Constraints.Required
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getIntroduced() {
        return introduced;
    }

    public void setIntroduced(Date introduced) {
        this.introduced = introduced;
    }

    public Date getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Date discontinued) {
        this.discontinued = discontinued;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
