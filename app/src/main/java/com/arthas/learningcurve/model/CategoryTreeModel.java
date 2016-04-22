package com.arthas.learningcurve.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tcz on 16/4/21.
 */
public class CategoryTreeModel implements Serializable{
    private Integer id;

    private Integer iconColor;

    private Integer level;

    private Integer parentId;

    private String iconFont;

    private String categoryName;

    private List<CategoryTreeModel> childList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIconColor() {
        return iconColor;
    }

    public void setIconColor(Integer iconColor) {
        this.iconColor = iconColor;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIconFont() {
        return iconFont;
    }

    public void setIconFont(String iconFont) {
        this.iconFont = iconFont == null ? null : iconFont.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public List<CategoryTreeModel> getChildList() {
        return childList;
    }

    public void setChildList(List<CategoryTreeModel> childList) {
        this.childList = childList;
    }
}
