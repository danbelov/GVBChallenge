package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class DBImage extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    public String description;
    @Lob
    public byte[] image;

    public static final Finder<Long, DBImage> find = new Finder<>(DBImage.class);
}