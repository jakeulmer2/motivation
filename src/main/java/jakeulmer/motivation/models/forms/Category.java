package jakeulmer.motivation.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int categoryId;

    @NotNull
    @Size(min=1, max=40)
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(){}

    public int getCategoryId() {return categoryId;}

    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}
}
