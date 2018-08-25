package models;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class DBImage extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @ManyToOne
    @JsonBackReference
    public DamageReport damageReport;

    public String description;
    public String mime;
    @Lob
    public byte[] image;

    public static final Finder<Long, DBImage> find = new Finder<>(DBImage.class);
}
