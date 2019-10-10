package com.xhw.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xhw
 * @Date: 2019-10-08 16:04
 * @Description:
 */
@ApiModel(description = "User实体Vo")
public class UserVo {

    @ApiModelProperty(value = "用户id",example = "1")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String userName;


    public UserVo(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UserVo() {
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}