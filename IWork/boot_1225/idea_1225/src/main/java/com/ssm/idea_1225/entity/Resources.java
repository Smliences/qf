package com.ssm.idea_1225.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author sml
 * @Time 2017-12-27 17:44
 **/

public class Resources implements Serializable {
    private String id;
    private String text;
    private String url;
    private String parentid;

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    private Set<Resources> children = new LinkedHashSet<Resources>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Resources> getChildren() {
        return children;
    }

    public void setChildren(Set<Resources> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
