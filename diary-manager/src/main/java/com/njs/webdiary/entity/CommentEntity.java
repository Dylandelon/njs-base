package com.njs.webdiary.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "df", catalog = "")
public class CommentEntity
{
    private int cid;
    private String content;
    private int rid;
    private int uid;
    private String commentTime;
    private ReplyEntity replyByRid;
    private UserEntity userByUid;

    @Id
    @Column(name = "cid", nullable = false)
    public int getCid()
    {
        return cid;
    }

    public void setCid(int cid)
    {
        this.cid = cid;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "rid", nullable = false,insertable = false,updatable = false)
    public int getRid()
    {
        return rid;
    }

    public void setRid(int rid)
    {
        this.rid = rid;
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
    @Column(name = "comment_time", nullable = true, length = 30)
    public String getCommentTime()
    {
        return commentTime;
    }

    public void setCommentTime(String commentTime)
    {
        this.commentTime = commentTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CommentEntity that = (CommentEntity) o;

        if (cid != that.cid)
            return false;
        if (rid != that.rid)
            return false;
        if (uid != that.uid)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (commentTime != null ? !commentTime.equals(that.commentTime) : that.commentTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = cid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + rid;
        result = 31 * result + uid;
        result = 31 * result + (commentTime != null ? commentTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "rid", referencedColumnName = "rid", nullable = false)
    public ReplyEntity getReplyByRid()
    {
        return replyByRid;
    }

    public void setReplyByRid(ReplyEntity replyByRid)
    {
        this.replyByRid = replyByRid;
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
