package com.demo.friend.Controller;

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

    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendId,@PathVariable String type){
        Claims claims= (Claims) request.getAttribute("claims_user");
        if(claims == null){
            return new Result(false, StatusCode.ERROR,"无登录");

        }
        String userid=claims.getId();
        if (type!=null) {
            if(type.equals("1")){
                int flag = friendService.addFriend(userid,friendId);
                if(flag == 0){
                    return new Result(false, StatusCode.ERROR,"不能重复添加");

                }
                if(flag == 1){
                    return new Result(true, StatusCode.OK,"成功");

                }
            }else if(type.equals("2")){

            }
            return new Result(false, StatusCode.ERROR,"参数不对");

        }else{
            return new Result(false, StatusCode.ERROR,"参数不对");
        }

    }
}
