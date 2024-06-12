package com.project.games_app.repository;

import com.project.games_app.models.Friend;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface FriendsRepository {

    @Insert("INSERT INTO app.friends " +
            "(id, player_id, friend_id, friends_since) " +
            "VALUES(#{id}, #{playerId}, #{friendId}, #{friendsSince})")
    void insert(Friend friend);

    @Select("SELECT * FROM app.friends WHERE player_id = #{playerId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "friendId", column = "friend_id"),
            @Result(property = "friendsSince", column = "friends_since")
    })
    List<Friend> findByPlayerId(@Param("playerId") UUID playerId);

    @Select("SELECT * FROM app.friends WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "friendId", column = "friend_id"),
            @Result(property = "friendsSince", column = "friends_since")
    })
    Optional<Friend> findById(@Param("id") UUID id);

    @Delete("DELETE FROM app.friends WHERE id = #{id}")
    void delete(@Param("id") UUID id);
}
