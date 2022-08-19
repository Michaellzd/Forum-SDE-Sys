package com.demo.friend.dao;

import com.demo.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {
    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public Friend findByuseridAndfriendid(String userid, String friendid);
    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?",nativeQuery = true)
    public void updateislike(String islike, String userid, String friendid);
}
