package models;

import enums.ReportStatus;

import org.joda.time.DateTime;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DamageReport extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    //@Enumerated(EnumType.STRING)
    //public ReportStatus status;
    public String status;

    public Double fraudScore;
    public String policeNr;
    public String name;
    public String email;

    public Long damageDate;

    public String damageSource;
    public String damagedItems;
    public String damageDescription;
    public String otherInformations;

    public Boolean offerExists;
    public Double costs;
    public Boolean selfEstimated;
    public Boolean billExists;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageReport") @JsonBackReference
    public List<DBImage> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageReport") @JsonBackReference
    public List<Event> events = new ArrayList<>();

    public static final Finder<Long, DamageReport> find = new Finder<>(DamageReport.class);
}
