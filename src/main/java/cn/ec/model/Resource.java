package cn.ec.model;

public class Resource {
    private Integer id;

    private String resourceSn;

    private String resourceName;

    private String resourceType;

    private String url;

    private String parentResourceSn;

    private Boolean hasMenuChildren;

    private Integer showSequence;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceSn() {
        return resourceSn;
    }

    public void setResourceSn(String resourceSn) {
        this.resourceSn = resourceSn == null ? null : resourceSn.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentResourceSn() {
        return parentResourceSn;
    }

    public void setParentResourceSn(String parentResourceSn) {
        this.parentResourceSn = parentResourceSn == null ? null : parentResourceSn.trim();
    }

    public Boolean getHasMenuChildren() {
        return hasMenuChildren;
    }

    public void setHasMenuChildren(Boolean hasMenuChildren) {
        this.hasMenuChildren = hasMenuChildren;
    }

    public Integer getShowSequence() {
        return showSequence;
    }

    public void setShowSequence(Integer showSequence) {
        this.showSequence = showSequence;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}