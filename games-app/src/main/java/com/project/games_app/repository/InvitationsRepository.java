package com.project.games_app.repository;

import com.project.games_app.models.Invitation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface InvitationsRepository {

    @Insert("INSERT INTO app.invitations " +
            "(id, player_id, friend_id) " +
            "VALUES(#{id}, #{playerId}, #{friendId})")
    void insert(Invitation invitation);

    @Select("SELECT * FROM app.invitations WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "friendId", column = "friend_id")
    })
    Optional<Invitation> findById(@Param("id") UUID id);

    @Select("SELECT * FROM app.invitations WHERE player_id = #{playerId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "friendId", column = "friend_id")
    })
    List<Invitation> findByPlayerId(@Param("playerId") UUID id);

    @Select("SELECT * FROM app.invitations WHERE friend_id = #{friendId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "friendId", column = "friend_id")
    })
    List<Invitation> findByFriendId(@Param("friendId") UUID id);

    @Delete("DELETE FROM app.invitations WHERE id = #{id}")
    void delete(@Param("id") UUID id);
}
