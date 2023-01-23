package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
@Immutable
@Table(name = "tt_user_group")
public class TtUserGroup {
    @Id

    @Column( "GROUP_ID")
    private Integer id;

    @Column( "SITE_ID")
    private Integer siteId;

    @Column( "GROUP_NAME")
    private String groupName;

    @Column("GROUP_LEVEL")
    private Integer groupLevel;

    @Column( "PARENT_GROUP")
    private Integer parentGroup;

    @Column("STATUS")
    private Integer status;

    @Column("CREATION_TIME")
    private Instant creationTime;

    @Column( "CREATED_BY")
    private Integer createdBy;

    @Column("LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column("DESCRIPTION")
    private String description;

    @Column( "FQN_NAME")
    private String fqnName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(Integer groupLevel) {
        this.groupLevel = groupLevel;
    }

    public Integer getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Integer parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFqnName() {
        return fqnName;
    }

    public void setFqnName(String fqnName) {
        this.fqnName = fqnName;
    }

}