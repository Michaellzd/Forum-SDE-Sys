package com.demo.friend.Service;

import com.demo.friend.dao.FriendDao;
import com.demo.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {
    @Autowired
    private FriendDao friendDao;
    public int addFriend(String userid, String friendId) {
        Friend friend = friendDao.findByuseridAndfriendid(userid, friendId);
        if(friend != null) return 0;

        friend=new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendId);
        friend.setIslike("0");
        friendDao.save(friend);

        if(friendDao.findByuseridAndfriendid(friendId, userid)!=null){
            friendDao.updateislike("1",userid,friendId);
            friendDao.updateislike("1",friendId,userid);

        }
        return 0;
    }
}
