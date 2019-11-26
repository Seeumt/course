package cn.ec.model;

public class RoleResource {
    private String roleSn;

    private String resourceSn;

    public String getRoleSn() {
        return roleSn;
    }

    public void setRoleSn(String roleSn) {
        this.roleSn = roleSn == null ? null : roleSn.trim();
    }

    public String getResourceSn() {
        return resourceSn;
    }

    public void setResourceSn(String resourceSn) {
        this.resourceSn = resourceSn == null ? null : resourceSn.trim();
    }
}
