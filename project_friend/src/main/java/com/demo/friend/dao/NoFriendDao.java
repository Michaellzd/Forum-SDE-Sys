package com.demo.friend.dao;

import com.demo.friend.pojo.Friend;
import com.demo.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoFriendDao extends JpaRepository<NoFriend,String> {
    public NoFriend findByUseridAndFriendid(String userid, String friendid);


}
