package cn.ec.model;

public class UserRole {
    private String pid;

    private String roleSn;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getRoleSn() {
        return roleSn;
    }

    public void setRoleSn(String roleSn) {
        this.roleSn = roleSn == null ? null : roleSn.trim();
    }
}
