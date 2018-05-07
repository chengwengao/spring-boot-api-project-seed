package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/07.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /*
    @PostMapping是@RequestMapping(method = RequestMethod.POST)的缩写
     */
    @RequestMapping(method = RequestMethod.POST, value = "list1")
    public Result list1(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getNameById")
    public Result getNameById(@RequestParam Integer id){
        User user = userService.findById(id);
        String name = null;
        if (null != user && StringUtils.isNotEmpty(user.getNickName())){
            name = user.getNickName();
        }
        return ResultGenerator.genSuccessResult(name);
    }

    /*
    @GetMapping是@RequestMapping(method = RequestMethod.GET)的缩写
     */
    @GetMapping(value = "getNameById1")
    public Result getNameById1(@RequestParam Integer id){
        User user = userService.findById(id);
        String name = null;
        if (null != user && StringUtils.isNotEmpty(user.getNickName())){
            name = user.getNickName();
        }
        return ResultGenerator.genSuccessResult(name);
    }

}