package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.joda.time.DateTime;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import enums.EventType;

@Entity
public class Event extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @ManyToOne
    @JsonBackReference
    public DamageReport damageReport;

    public Long time;

    @Enumerated(EnumType.STRING)
    public EventType type;

    public String text;

    public static final Finder<Long, Event> find = new Finder<>(Event.class);
}
