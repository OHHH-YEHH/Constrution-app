package com.svjadhavcontractors.secondpagepofadmin;

import java.io.Serializable;

public class SiteObject implements Serializable {
    private String CategoryName;
    private String NameOfSite;
    private String Area;
    private String SupervisorName;

    public SiteObject() {
    }

    public SiteObject(String nameOfSite, String area, String supervisorName) {
        NameOfSite = nameOfSite;
        Area = area;
        SupervisorName = supervisorName;
    }

    public SiteObject(String categoryName, String nameOfSite, String area, String supervisorName) {
        CategoryName = categoryName;
        NameOfSite = nameOfSite;
        Area = area;
        SupervisorName = supervisorName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getNameOfSite() {
        return NameOfSite;
    }

    public String getArea() {
        return Area;
    }

    public String getSupervisorName() {
        return SupervisorName;
    }
}

