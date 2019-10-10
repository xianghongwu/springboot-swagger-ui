package com.xhw.swagger.controller;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.xhw.swagger.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xhw
 * @Date: 2019-10-08 16:05
 * @Description:
 */
@RestController
@RequestMapping("user")
@Api(tags="user模块")//用在类上，说明该类的作用。
public class UserController {

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个的用户信息")//注解来给API增加方法说明。
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true)//用来注解来给方法入参增加说明。
    @GetMapping("get/{id}")//Conntroller中定义的方法必须在@RequestMapper中显示的指定RequestMethod类型，否则SawggerUi会默认为全类型皆可访问， API列表中会生成多条项目。
    public String getUserById(@PathVariable int id) {
        if(id == 0){
            return "查无此人";
        }else{
            return "{\"id\":\""+id+"\",\"userName\":\"张三\"}";
        }
    }

    /*paramType=：指定参数放在哪个地方   默认是body
        * header：请求参数放置于Request Header，使用@RequestHeader获取
          query：请求参数放置于请求地址，使用@RequestParam获取
          path：（用于restful接口）-->请求参数的获取：@PathVariable
          body：（不常用）
          form（不常用）
    * */
    @ApiOperation(value = "获取所有的用户信息", notes = "暂时不分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageSize",value = "页容量",paramType = "query",required =false,defaultValue = "10",dataType = "Integer"),
            @ApiImplicitParam(name="pageIndex",value = "当前页",paramType = "query",required =false,defaultValue="1" ),
            @ApiImplicitParam(paramType="header", name = "token", value = "token", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="header", name = "username", value = "username", required = true, dataType = "String"),
    })
    @GetMapping("list")
    public List<UserVo> getUserList(@RequestParam Integer pageSize,@RequestParam Integer pageIndex,@RequestHeader String username, HttpServletRequest request) {
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageIndex:"+pageIndex);
        String token = request.getHeader("token");
        System.out.println("token："+token);
        System.out.println("username："+username);

        UserVo userVo1=new UserVo(1,pageSize+"");
        UserVo userVo2=new UserVo(2,pageIndex+"");
        UserVo userVo3=new UserVo(3,token);
        UserVo userVo4=new UserVo(4,username);
        List<UserVo> list=new ArrayList<>();
        list.add(userVo1);
        list.add(userVo2);
        list.add(userVo3);
        list.add(userVo4);
        return  list;
    }

    @ApiOperation(value = "根据UserVo对象查询用户信息", notes = "查询数据库中符合条件的用户信息")
    @PostMapping("listbyUser")
    @ApiResponse(code = 400,message ="请求参数没填好",reference = "asdfasdf")
    public String getUserByUser(UserVo userVo) {
        if(userVo.getId() == 0){
            return "查无此人";
        }else{
            return userVo.toString();
        }
    }

}