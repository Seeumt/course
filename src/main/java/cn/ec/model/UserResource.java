package cn.ec.model;

public class UserResource {
    private String pid;

    private String resourceSn;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getResourceSn() {
        return resourceSn;
    }

    public void setResourceSn(String resourceSn) {
        this.resourceSn = resourceSn == null ? null : resourceSn.trim();
    }
}