package models;

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

    public DateTime time;

    @Enumerated(EnumType.STRING)
    public EventType type;

    public String text;

    public static final Finder<Long, Event> find = new Finder<>(Event.class);
}
