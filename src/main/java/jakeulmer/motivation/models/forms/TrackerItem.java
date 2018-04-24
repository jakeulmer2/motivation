package jakeulmer.motivation.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TrackerItem {

    @Id
    @GeneratedValue
    private int trackerItemId;

    @NotNull
    @Size(min=1, max=50)
    private String trackerItemName;

    public TrackerItem(String trackerItemName) {
        this.trackerItemName = trackerItemName;
    }

    public TrackerItem(){}

    public int getTrackerItemId() {return trackerItemId;}

    public String getTrackerItmeName() {return trackerItemName;}

    public void setTrackerItemName(String trackerItemName) {this.trackerItemName = trackerItemName;}
}
