package com.njs.webdiary.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "post", schema = "df", catalog = "")
public class PostEntity
{
    private int pid;
    private String title;
    private String content;
    private String publishTime;
    private String replyTime;
    private Integer replyCount;
    private Integer likeCount;
    private Integer scanCount;
    private int uid;
    private int tid;
    private UserEntity userByUid;
    private TopicEntity topicByTid;
    private Collection<ReplyEntity> repliesByPid;

    public PostEntity(int pid)
    {
        this.pid = pid;
    }

    public PostEntity()
    {
    }

    @Id
    @Column(name = "pid", nullable = false)
    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
    @Column(name = "publish_time", nullable = false, length = 30)
    public String getPublishTime()
    {
        return publishTime;
    }

    public void setPublishTime(String publishTime)
    {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "reply_time", nullable = false, length = 30)
    public String getReplyTime()
    {
        return replyTime;
    }

    public void setReplyTime(String replyTime)
    {
        this.replyTime = replyTime;
    }

    @Basic
    @Column(name = "reply_count", nullable = true)
    public Integer getReplyCount()
    {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount)
    {
        this.replyCount = replyCount;
    }

    @Basic
    @Column(name = "like_count", nullable = true)
    public Integer getLikeCount()
    {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount)
    {
        this.likeCount = likeCount;
    }

    @Basic
    @Column(name = "scan_count", nullable = true)
    public Integer getScanCount()
    {
        return scanCount;
    }

    public void setScanCount(Integer scanCount)
    {
        this.scanCount = scanCount;
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
    @Column(name = "tid", nullable = false,insertable = false,updatable = false)
    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PostEntity that = (PostEntity) o;

        if (pid != that.pid)
            return false;
        if (uid != that.uid)
            return false;
        if (tid != that.tid)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null)
            return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null)
            return false;
        if (replyCount != null ? !replyCount.equals(that.replyCount) : that.replyCount != null)
            return false;
        if (likeCount != null ? !likeCount.equals(that.likeCount) : that.likeCount != null)
            return false;
        if (scanCount != null ? !scanCount.equals(that.scanCount) : that.scanCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = pid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        result = 31 * result + (replyCount != null ? replyCount.hashCode() : 0);
        result = 31 * result + (likeCount != null ? likeCount.hashCode() : 0);
        result = 31 * result + (scanCount != null ? scanCount.hashCode() : 0);
        result = 31 * result + uid;
        result = 31 * result + tid;
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

    @ManyToOne
    @JoinColumn(name = "tid", referencedColumnName = "tid", nullable = false)
    public TopicEntity getTopicByTid()
    {
        return topicByTid;
    }

    public void setTopicByTid(TopicEntity topicByTid)
    {
        this.topicByTid = topicByTid;
    }

    @OneToMany(mappedBy = "postByPid")
    public Collection<ReplyEntity> getRepliesByPid()
    {
        return repliesByPid;
    }

    public void setRepliesByPid(Collection<ReplyEntity> repliesByPid)
    {
        this.repliesByPid = repliesByPid;
    }
}
