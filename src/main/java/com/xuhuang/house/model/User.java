package com.xuhuang.house.model;

import org.springframework.web.multipart.MultipartFile;

public class User
{
    private long id;

    private String name;

    private String phone;

    private String email;

    private String aboutme;

    private String passwd;

    private String avatar;

    private Integer type;

    private long createTime;

    private int enable;

    private MultipartFile avatarFile;

    private String confirmPasswd;

    private String key;

    private long agencyId;

    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAboutme()
    {
        return aboutme;
    }

    public void setAboutme(String aboutme)
    {
        this.aboutme = aboutme;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public long getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(long createTime)
    {
        this.createTime = createTime;
    }

    public int getEnable()
    {
        return enable;
    }

    public void setEnable(int enable)
    {
        this.enable = enable;
    }

    public long getAgencyId()
    {
        return agencyId;
    }

    public void setAgencyId(long agencyId)
    {
        this.agencyId = agencyId;
    }

    public MultipartFile getAvatarFile()
    {
        return avatarFile;
    }

    public void setAvatarFile(MultipartFile avatarFile)
    {
        this.avatarFile = avatarFile;
    }

    public String getConfirmPasswd()
    {
        return confirmPasswd;
    }

    public void setConfirmPasswd(String confirmPasswd)
    {
        this.confirmPasswd = confirmPasswd;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
