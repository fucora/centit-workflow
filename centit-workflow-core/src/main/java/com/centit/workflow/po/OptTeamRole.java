package com.centit.workflow.po;

import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chen_rj on 2017-9-19.
 * 这个更名为 WF_FLOW_TEAM_ROLE
 * 和流程关联
 */
@Entity
@Table(name = "WF_FLOW_TEAM_ROLE")
public class OptTeamRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "OPT_TEAM_ROLE_ID")
    private String optTeamRoleId;
    @NotNull
    @Column(name = "FLOW_CODE")
    private String flowCode;
    @NotNull
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @NotNull
    @Column(name = "OPT_ROLE_NAME")
    private String roleName;
    @Column(name = "OPT_TEAM_ROLE_ORDER")
    private Integer optTeamRoleOrder;
    @Column(name = "GMT_CREATE_TIME")
    private Date gmtCreateTime;
    @Column(name = "GMT_MODIFY_TIME")
    private Date gmtModifyTime;

    public String getOptTeamRoleId() {
        return optTeamRoleId;
    }

    public void setOptTeamRoleId(String optTeamRoleId) {
        this.optTeamRoleId = optTeamRoleId;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getOptRoleCode() {
        return optRoleCode;
    }

    public void setOptRoleCode(String optRoleCode) {
        this.optRoleCode = optRoleCode;
    }

    public String getOptRoleName() {
        return optRoleName;
    }

    public void setOptRoleName(String optRoleName) {
        this.optRoleName = optRoleName;
    }

    public Integer getOptTeamRoleOrder() {
        return optTeamRoleOrder;
    }

    public void setOptTeamRoleOrder(Integer optTeamRoleOrder) {
        this.optTeamRoleOrder = optTeamRoleOrder;
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtModifyTime() {
        return gmtModifyTime;
    }

    public void setGmtModifyTime(Date gmtModifyTime) {
        this.gmtModifyTime = gmtModifyTime;
    }
}
