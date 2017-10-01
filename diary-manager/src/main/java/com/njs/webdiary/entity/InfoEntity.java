package com.njs.webdiary.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "info", schema = "df", catalog = "")
public class InfoEntity
{
    private int iid;
    private String requestUrl;
    private String contextPath;
    private String remoteAddr;
    private Timestamp accessTime;

    @Id
    @Column(name = "iid", nullable = false)
    public int getIid()
    {
        return iid;
    }

    public void setIid(int iid)
    {
        this.iid = iid;
    }

    @Basic
    @Column(name = "request_url", nullable = true, length = 300)
    public String getRequestUrl()
    {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl)
    {
        this.requestUrl = requestUrl;
    }

    @Basic
    @Column(name = "context_path", nullable = true, length = 30)
    public String getContextPath()
    {
        return contextPath;
    }

    public void setContextPath(String contextPath)
    {
        this.contextPath = contextPath;
    }

    @Basic
    @Column(name = "remote_addr", nullable = true, length = 30)
    public String getRemoteAddr()
    {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr)
    {
        this.remoteAddr = remoteAddr;
    }

    @Basic
    @Column(name = "access_time", nullable = false)
    public Timestamp getAccessTime()
    {
        return accessTime;
    }

    public void setAccessTime(Timestamp accessTime)
    {
        this.accessTime = accessTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        InfoEntity that = (InfoEntity) o;

        if (iid != that.iid)
            return false;
        if (requestUrl != null ? !requestUrl.equals(that.requestUrl) : that.requestUrl != null)
            return false;
        if (contextPath != null ? !contextPath.equals(that.contextPath) : that.contextPath != null)
            return false;
        if (remoteAddr != null ? !remoteAddr.equals(that.remoteAddr) : that.remoteAddr != null)
            return false;
        if (accessTime != null ? !accessTime.equals(that.accessTime) : that.accessTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = iid;
        result = 31 * result + (requestUrl != null ? requestUrl.hashCode() : 0);
        result = 31 * result + (contextPath != null ? contextPath.hashCode() : 0);
        result = 31 * result + (remoteAddr != null ? remoteAddr.hashCode() : 0);
        result = 31 * result + (accessTime != null ? accessTime.hashCode() : 0);
        return result;
    }
}
