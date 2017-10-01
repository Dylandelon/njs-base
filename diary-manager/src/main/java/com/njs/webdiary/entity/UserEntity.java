package com.njs.webdiary.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "df", catalog = "")
public class UserEntity
{
    private int uid;
    private String email;
    private String password;
    private int actived;
    private String activateCode;
    private String joinTime;
    private String username;
    private String description;
    private String headUrl;
    private String position;
    private String school;
    private String job;
    private Integer likeCount;
    private Integer postCount;
    private Integer scanCount;
    private Integer followCount;
    private Integer followerCount;
    private Collection<CommentEntity> commentsByUid;
    private Collection<MessageEntity> messagesByUid;
    private Collection<PostEntity> postsByUid;
    private Collection<ReplyEntity> repliesByUid;

    public UserEntity()
    {
    }

    public UserEntity(int uid)
    {
        this.uid = uid;
    }

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "actived", nullable = false)
    public int getActived()
    {
        return actived;
    }

    public void setActived(int actived)
    {
        this.actived = actived;
    }

    @Basic
    @Column(name = "activate_code", nullable = false, length = 60)
    public String getActivateCode()
    {
        return activateCode;
    }

    public void setActivateCode(String activateCode)
    {
        this.activateCode = activateCode;
    }

    @Basic
    @Column(name = "join_time", nullable = false, length = 30)
    public String getJoinTime()
    {
        return joinTime;
    }

    public void setJoinTime(String joinTime)
    {
        this.joinTime = joinTime;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 30)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Basic
    @Column(name = "head_url", nullable = false, length = 100)
    public String getHeadUrl()
    {
        return headUrl;
    }

    public void setHeadUrl(String headUrl)
    {
        this.headUrl = headUrl;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 20)
    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    @Basic
    @Column(name = "school", nullable = true, length = 20)
    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    @Basic
    @Column(name = "job", nullable = true, length = 20)
    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
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
    @Column(name = "post_count", nullable = true)
    public Integer getPostCount()
    {
        return postCount;
    }

    public void setPostCount(Integer postCount)
    {
        this.postCount = postCount;
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
    @Column(name = "follow_count", nullable = true)
    public Integer getFollowCount()
    {
        return followCount;
    }

    public void setFollowCount(Integer followCount)
    {
        this.followCount = followCount;
    }

    @Basic
    @Column(name = "follower_count", nullable = true)
    public Integer getFollowerCount()
    {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount)
    {
        this.followerCount = followerCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity that = (UserEntity) o;

        if (uid != that.uid)
            return false;
        if (actived != that.actived)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (activateCode != null ? !activateCode.equals(that.activateCode) : that.activateCode != null)
            return false;
        if (joinTime != null ? !joinTime.equals(that.joinTime) : that.joinTime != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (headUrl != null ? !headUrl.equals(that.headUrl) : that.headUrl != null)
            return false;
        if (position != null ? !position.equals(that.position) : that.position != null)
            return false;
        if (school != null ? !school.equals(that.school) : that.school != null)
            return false;
        if (job != null ? !job.equals(that.job) : that.job != null)
            return false;
        if (likeCount != null ? !likeCount.equals(that.likeCount) : that.likeCount != null)
            return false;
        if (postCount != null ? !postCount.equals(that.postCount) : that.postCount != null)
            return false;
        if (scanCount != null ? !scanCount.equals(that.scanCount) : that.scanCount != null)
            return false;
        if (followCount != null ? !followCount.equals(that.followCount) : that.followCount != null)
            return false;
        if (followerCount != null ? !followerCount.equals(that.followerCount) : that.followerCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = uid;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + actived;
        result = 31 * result + (activateCode != null ? activateCode.hashCode() : 0);
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (headUrl != null ? headUrl.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (likeCount != null ? likeCount.hashCode() : 0);
        result = 31 * result + (postCount != null ? postCount.hashCode() : 0);
        result = 31 * result + (scanCount != null ? scanCount.hashCode() : 0);
        result = 31 * result + (followCount != null ? followCount.hashCode() : 0);
        result = 31 * result + (followerCount != null ? followerCount.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<CommentEntity> getCommentsByUid()
    {
        return commentsByUid;
    }

    public void setCommentsByUid(Collection<CommentEntity> commentsByUid)
    {
        this.commentsByUid = commentsByUid;
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<MessageEntity> getMessagesByUid()
    {
        return messagesByUid;
    }

    public void setMessagesByUid(Collection<MessageEntity> messagesByUid)
    {
        this.messagesByUid = messagesByUid;
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<PostEntity> getPostsByUid()
    {
        return postsByUid;
    }

    public void setPostsByUid(Collection<PostEntity> postsByUid)
    {
        this.postsByUid = postsByUid;
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<ReplyEntity> getRepliesByUid()
    {
        return repliesByUid;
    }

    public void setRepliesByUid(Collection<ReplyEntity> repliesByUid)
    {
        this.repliesByUid = repliesByUid;
    }
}
