package jakeulmer.motivation.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tracker {

    @Id
    @GeneratedValue
    private int trackerId;

    @NotNull
    @Size(min=1, max=50)
    private String trackerName;

    public Tracker(String trackerName) {
        this.trackerName = trackerName;
    }

    public Tracker(){}

    public int getTrackerId() {return trackerId;}

    public String getTrackerName() {return trackerName;}

    public void setTrackerName(String trackerName) {this.trackerName = trackerName;}
}
