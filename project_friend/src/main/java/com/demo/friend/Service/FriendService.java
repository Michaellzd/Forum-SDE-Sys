package com.demo.friend.Service;

import com.demo.friend.dao.FriendDao;
import com.demo.friend.dao.NoFriendDao;
import com.demo.friend.pojo.Friend;
import com.demo.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {
    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;
    public int addFriend(String userid, String friendId) {
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendId);
        if(friend != null) return 0;

        friend=new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendId);
        friend.setIslike("0");
        friendDao.save(friend);

        if(friendDao.findByUseridAndFriendid(friendId, userid)!=null){
            friendDao.updateislike("1",userid,friendId);
            friendDao.updateislike("1",friendId,userid);

        }
        return 0;
    }

    public int addNoFriend(String userid, String friendid) {
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        if (noFriend != null) {
          return 0;
        }
        noFriend=new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        //删除friend user
        friendDao.deleteFriend(userid,friendid);
        //islike 0
        friendDao.updateislike("0",friendid,userid);
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }
}
