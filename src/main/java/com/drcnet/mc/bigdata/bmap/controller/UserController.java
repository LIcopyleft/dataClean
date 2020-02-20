package com.drcnet.mc.bigdata.bmap.controller;/*
package com.drcnet.mc.bigdata.bmap.controller;

import com.drcnet.mc.bigdata.bmap.entity.token.User;
import com.drcnet.mc.bigdata.bmap.entity.token.UserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drcnet.mc.bigdata.bmap.Utils.InterceptorUtils;
import com.drcnet.mc.bigdata.bmap.Utils.Result;
import com.drcnet.mc.bigdata.bmap.dto.ChangePassDTO;
import com.drcnet.mc.bigdata.bmap.dto.SysLabelDTO;
import com.drcnet.mc.bigdata.bmap.dto.SysUserDTO;
import com.drcnet.mc.bigdata.bmap.service.UserService;
import com.drcnet.mc.bigdata.bmap.service.token.TokenService;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    private TokenService tokenService;

*/
/*
    @PostMapping("/add")
    @ApiOperation(value = "添加系统用户接口")
    public Result addSysUser(@RequestBody SysUserDTO dto) throws Exception {

        sysUserService.addSysUser(dto);
        return Result.success(dto);
    }*//*


    @PostMapping("/modify")
    @ApiOperation(value = "修改用户接口")
    public Result modifySysUser(@RequestBody SysUserDTO dto, HttpServletRequest request) throws Exception {
        String token = InterceptorUtils.getAuthorization(request);
        User user = tokenService.convertToken(token).getUser();
        dto.setUserId(user.getUserId());
        dto.setUpdateUser(user.getUserId());
        return userService.modifyUser(dto);
    }


    @GetMapping("/info")
    @ApiOperation(value = "查询用户信息接口")
    public Result findSysUser(HttpServletRequest request) {
        String token = InterceptorUtils.getAuthorization(request);
        User user = tokenService.convertToken(token).getUser();
        return userService.findSysUserById(user.getUserId(),user.getAppId());

    }

    @PostMapping("/pass/change")
    @ApiOperation(value = "用户修改密码接口")
    public Result modifyPasswd(@RequestBody ChangePassDTO dto, HttpServletRequest request) throws Exception {
        String token = InterceptorUtils.getAuthorization(request);
        dto.setUserId(tokenService.convertToken(token).getUser().getUserId());
        return userService.changePass(dto);

    }

    */
/***************************用户标签信息***********************//*


    @GetMapping("/label/{userId}")
    @ApiOperation(value = "获取用户标签信息")
    public Result getUserLabel(@PathVariable()Integer userId, HttpServletRequest request) throws Exception {

        String token = InterceptorUtils.getAuthorization(request);
        UserToken userToken = tokenService.convertToken(token);
        User user = userToken.getUser();
        userId = user.getUserId();
        Integer appId = user.getAppId();
        //当前系统appid 下 用户标签信息
        return labelService.findLabelByUserId(userId,appId);
//        String token = InterceptorUtils.getAuthorization(request);
//        return labelService.findLabelByUserId(tokenService.convertToken(token).getUser().getUserId());

    }

    @PostMapping("/label/add")
    @ApiOperation(value = "用户添加标签信息")
    public Result getUserLabel(@RequestBody SysLabelDTO record, HttpServletRequest request) throws Exception {
        String token = InterceptorUtils.getAuthorization(request);
        record.setUserId(tokenService.convertToken(token).getUser().getUserId());
        record.setAppId(tokenService.convertToken(token).getUser().getAppId());
       return labelService.addLabel(record);
    }

    @PostMapping("/label/modify")
    @ApiOperation(value = "用户标签信息")
    public Result modifyUserLabel(@RequestBody SysLabelDTO record, HttpServletRequest request) throws Exception {
        String token = InterceptorUtils.getAuthorization(request);
        record.setUserId(tokenService.convertToken(token).getUser().getUserId());
        return labelService.modifyUserLabel(record);

    }

    @RequestMapping("/label/del")
    @ApiOperation(value = "删除用户标签信息")
    public Result delUserLabel(@RequestBody SysLabelDTO dto, HttpServletRequest request) throws Exception {

//        List<LabelResultDTO> result = labelService.findLabelByUserId(userId);
        String token = InterceptorUtils.getAuthorization(request);
        return labelService.delUserLabelBylabelId(dto.getLabelId(), tokenService.convertToken(token).getUser().getUserId());

    }

    @PostMapping("/region/modify")
    @ApiOperation(value = "用户默认地区修改接口")
    public Result modifyUserDefRegion(@RequestBody SysUserDTO req, HttpServletRequest request) throws Exception {

//        List<LabelResultDTO> result = labelService.findLabelByUserId(userId);
        String token = InterceptorUtils.getAuthorization(request);
        return userService.modifyUserDefRegion(req.getRegionId(),tokenService.convertToken(token).getUser().getUserId());

    }

}
*/
