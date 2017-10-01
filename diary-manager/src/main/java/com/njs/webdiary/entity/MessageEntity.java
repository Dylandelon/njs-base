package com.njs.webdiary.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message", schema = "df", catalog = "")
public class MessageEntity
{
    private int mid;
    private int uid;
    private int otherId;
    private String otherUsername;
    private int postId;
    private String operation;
    private String displayedContent;
    private Timestamp msgTime;
    private UserEntity userByUid;

    @Id
    @Column(name = "mid", nullable = false)
    public int getMid()
    {
        return mid;
    }

    public void setMid(int mid)
    {
        this.mid = mid;
    }

    @Basic
    @Column(name = "uid", nullable = false,insertable = false,updatable = false)
    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    @Basic
    @Column(name = "other_id", nullable = false)
    public int getOtherId()
    {
        return otherId;
    }

    public void setOtherId(int otherId)
    {
        this.otherId = otherId;
    }

    @Basic
    @Column(name = "other_username", nullable = false, length = 20)
    public String getOtherUsername()
    {
        return otherUsername;
    }

    public void setOtherUsername(String otherUsername)
    {
        this.otherUsername = otherUsername;
    }

    @Basic
    @Column(name = "post_id", nullable = false)
    public int getPostId()
    {
        return postId;
    }

    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    @Basic
    @Column(name = "operation", nullable = false, length = 20)
    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    @Basic
    @Column(name = "displayed_content", nullable = false, length = 100)
    public String getDisplayedContent()
    {
        return displayedContent;
    }

    public void setDisplayedContent(String displayedContent)
    {
        this.displayedContent = displayedContent;
    }

    @Basic
    @Column(name = "msg_time", nullable = false)
    public Timestamp getMsgTime()
    {
        return msgTime;
    }

    public void setMsgTime(Timestamp msgTime)
    {
        this.msgTime = msgTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MessageEntity that = (MessageEntity) o;

        if (mid != that.mid)
            return false;
        if (uid != that.uid)
            return false;
        if (otherId != that.otherId)
            return false;
        if (postId != that.postId)
            return false;
        if (otherUsername != null ? !otherUsername.equals(that.otherUsername) : that.otherUsername != null)
            return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null)
            return false;
        if (displayedContent != null ? !displayedContent.equals(that.displayedContent) : that.displayedContent != null)
            return false;
        if (msgTime != null ? !msgTime.equals(that.msgTime) : that.msgTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = mid;
        result = 31 * result + uid;
        result = 31 * result + otherId;
        result = 31 * result + (otherUsername != null ? otherUsername.hashCode() : 0);
        result = 31 * result + postId;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (displayedContent != null ? displayedContent.hashCode() : 0);
        result = 31 * result + (msgTime != null ? msgTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid", nullable = false)
    public UserEntity getUserByUid()
    {
        return userByUid;
    }

    public void setUserByUid(UserEntity userByUid)
    {
        this.userByUid = userByUid;
    }
}
