package com.xiaohei.dubbo.study.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaohei.dubbo.study.common.entity.User;
import com.xiaohei.dubbo.study.provider.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Reference
    UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据用户id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        User user = userService.get(id);
        return user;
    }


    @ApiOperation(value = "更新用户详细信息", notes = "根据用户I的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public int update(@PathVariable("id") int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long", paramType = "path")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
