package jakeulmer.motivation.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tracker {

    @Id
    @GeneratedValue
    private int trackerId;

    @NotNull
    @Size(min=1, max=50)
    private String trackerName;

    @OneToMany
    @JoinColumn(name = "trackerId")
    private List<TrackerItem> trackerItem = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "trackerId")
    private List<Category> catergory = new ArrayList<>();

    public Tracker(String trackerName) {
        this.trackerName = trackerName;
    }

    public Tracker(){}

    public int getTrackerId() {return trackerId;}

    public String getTrackerName() {return trackerName;}

    public void setTrackerName(String trackerName) {this.trackerName = trackerName;}

    public List<TrackerItem> getTrackerItem() {return trackerItem;}

    public void setTrackerItem(List<TrackerItem> trackerItem) {this.trackerItem = trackerItem;}

    public List<Category> getCatergory() {return catergory;}

    public void setCatergory(List<Category> catergory) {this.catergory = catergory;}
}
