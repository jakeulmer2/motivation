package jakeulmer.motivation.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CheckLists {

    @Id
    @GeneratedValue
    private int checkListsId;

    @NotNull
    @Size(min=1, max=50)
    private String checkListName;

    //@Id
    //@GeneratedValue
    @NotNull
    @Size(min=1, max=50)
    private String checkListItem;

    @NotNull
    private ArrayList<String> userList = new ArrayList<String>();

    public CheckLists(String checkListName, ArrayList<String> userList, String checkListItem) {
        this.checkListName = checkListName;
        this.userList = userList;
        this.checkListItem = checkListItem;
    }

    public CheckLists(){}


}
