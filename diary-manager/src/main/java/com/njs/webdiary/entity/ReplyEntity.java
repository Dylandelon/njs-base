package com.njs.webdiary.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "reply", schema = "df", catalog = "")
public class ReplyEntity
{
    private int rid;
    private String content;
    private int pid;
    private int uid;
    private String replyTime;
    private Collection<CommentEntity> commentsByRid;
    private PostEntity postByPid;
    private UserEntity userByUid;

    public ReplyEntity(int rid)
    {
        this.rid = rid;
    }

    public ReplyEntity()
    {
    }

    @Id
    @Column(name = "rid", nullable = false)
    public int getRid()
    {
        return rid;
    }

    public void setRid(int rid)
    {
        this.rid = rid;
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
    @Column(name = "pid", nullable = false,insertable = false,updatable = false)
    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
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
    @Column(name = "reply_time", nullable = true, length = 30)
    public String getReplyTime()
    {
        return replyTime;
    }

    public void setReplyTime(String replyTime)
    {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReplyEntity that = (ReplyEntity) o;

        if (rid != that.rid)
            return false;
        if (pid != that.pid)
            return false;
        if (uid != that.uid)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = rid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + pid;
        result = 31 * result + uid;
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "replyByRid")
    public Collection<CommentEntity> getCommentsByRid()
    {
        return commentsByRid;
    }

    public void setCommentsByRid(Collection<CommentEntity> commentsByRid)
    {
        this.commentsByRid = commentsByRid;
    }

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid", nullable = false)
    public PostEntity getPostByPid()
    {
        return postByPid;
    }

    public void setPostByPid(PostEntity postByPid)
    {
        this.postByPid = postByPid;
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
