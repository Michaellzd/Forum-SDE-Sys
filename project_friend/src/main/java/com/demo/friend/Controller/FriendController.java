package com.demo.friend.Controller;

import com.demo.friend.Client.UserClient;
import com.demo.friend.Service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type){
        Claims claims= (Claims) request.getAttribute("user_claims");
        System.out.println(claims);
        if(claims == null){
            return new Result(false, StatusCode.ERROR,"无登录");

        }
        String userid=claims.getId();
        if (type!=null) {
            if(type.equals("1")){
                int flag = friendService.addFriend(userid,friendid);
                if(flag == 0){
                    return new Result(false, StatusCode.ERROR,"不能重复添加");

                }
                if(flag == 1){
                    userClient.updatefanscountandfollowcount(userid,friendid,1);
                    return new Result(true, StatusCode.OK,"成功");

                }
            }else if(type.equals("2")){
                int flag = friendService.addNoFriend(userid, friendid);
                System.out.println(flag);
                //非好友
                if(flag == 0){
                    return new Result(false, StatusCode.ERROR,"不能重复添加");

                }
                if(flag == 1){
                    return new Result(true, StatusCode.OK,"成功");

                }
            }
            return new Result(false, StatusCode.ERROR,"参数不对");

        }else{
            return new Result(false, StatusCode.ERROR,"参数不对");
        }

    }


    @RequestMapping(value = "{friendid}",method = RequestMethod.DELETE)
    public Result deleteFriend(@PathVariable String friendid){

        Claims claims= (Claims) request.getAttribute("user_claims");
        System.out.println(claims);
        if(claims == null){
            return new Result(false, StatusCode.ERROR,"无登录");

        }
        String userid=claims.getId();
        friendService.deleteFriend(userid,friendid);
        userClient.updatefanscountandfollowcount(userid,friendid,-1);
        return new Result(true, StatusCode.OK,"成功");


    }
}
