package com.njs.webdiary.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "topic", schema = "df", catalog = "")
public class TopicEntity
{
    private int tid;
    private String name;
    private String content;
    private String image;
    private Collection<PostEntity> postsByTid;

    @Id
    @Column(name = "tid", nullable = false)
    public int getTid()
    {
        return tid;
    }

    public void setTid(int tid)
    {
        this.tid = tid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 50)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 100)
    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TopicEntity that = (TopicEntity) o;

        if (tid != that.tid)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (image != null ? !image.equals(that.image) : that.image != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = tid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "topicByTid")
    public Collection<PostEntity> getPostsByTid()
    {
        return postsByTid;
    }

    public void setPostsByTid(Collection<PostEntity> postsByTid)
    {
        this.postsByTid = postsByTid;
    }
}
