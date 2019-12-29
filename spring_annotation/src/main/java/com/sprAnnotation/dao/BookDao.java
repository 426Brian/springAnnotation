package com.sprAnnotation.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Brian in 7:16 2018/12/12
 */

@Repository
public class BookDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
