package com.arthas.learningcurve.model;

import java.util.List;

/**
 * Created by Tcz on 16/4/19.
 */
public class CategoryModel extends BaseModel {
    private Integer id;
    private String icon;
    private int iconColor;
    private String categoryName;
    private List<CategoryModel> childCategoryList;
    private Integer childPlanCount;
    private List<PlanModel> childPlanList;//预留
    private int level;


    public CategoryModel() {
    }

    public CategoryModel(String icon, String categoryName) {
        this.icon = icon;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryModel> getChildCategoryList() {
        return childCategoryList;
    }

    public void setChildCategoryList(List<CategoryModel> childCategoryList) {
        this.childCategoryList = childCategoryList;
    }

    public Integer getChildPlanCount() {
        return childPlanCount;
    }

    public void setChildPlanCount(Integer childPlanCount) {
        this.childPlanCount = childPlanCount;
    }

    public List<PlanModel> getChildPlanList() {
        return childPlanList;
    }

    public void setChildPlanList(List<PlanModel> childPlanList) {
        this.childPlanList = childPlanList;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }
}
