package models;

import enums.ReportStatus;

import org.joda.time.DateTime;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class DamageReport extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Enumerated(EnumType.STRING)
    public ReportStatus status;

    public double fraudScore;
    public String policeNr;
    public String name;
    public String email;

    public DateTime damageDate;

    public String damageSource;
    public String damagedItems;
    public String damageDescription;
    public String otherInformations;

    public boolean offerExists;
    public double costs;
    public boolean selfEstimated;
    public boolean billExists;

    @OneToMany(cascade = CascadeType.ALL)
    public List<DBImage> images;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Event> events;

    public static final Finder<Long, Model> find = new Finder<>(Model.class);
}
