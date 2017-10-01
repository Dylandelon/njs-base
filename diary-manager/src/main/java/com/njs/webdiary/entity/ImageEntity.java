package com.njs.webdiary.entity;

import javax.persistence.*;

@Entity
@Table(name = "image", schema = "df", catalog = "")
public class ImageEntity
{
    private int iid;
    private String imageUrl;

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
    @Column(name = "image_url", nullable = true, length = 255)
    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ImageEntity that = (ImageEntity) o;

        if (iid != that.iid)
            return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = iid;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
