package com.project.games_app.repository;

import com.project.games_app.models.Player;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface PlayerRepository {

    @Insert("INSERT INTO app.player "
    + "(id, email, nickname, password, points, last_online, profile_picture_url) "
    + "VALUES (#{id}, #{email}, #{nickname}, #{password}, #{points}, #{lastOnline}, #{profilePictureUrl})")
    void insert(Player player);

    @Select("SELECT * FROM app.player WHERE email = #{email}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    Optional<Player> findByEmail(@Param("email") String email);

    @Select("SELECT * FROM app.player WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    Optional<Player> findById(@Param("id") UUID id);

    @Select("SELECT * FROM app.player WHERE nickname = #{nickname}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    Optional<Player> findByNickname(@Param("nickname") String nickname);

    @Select("SELECT * FROM app.player")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    List<Player> findAll();

    @Select("SELECT * FROM app.player ORDER BY points DESC LIMIT 15")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    List<Player> findAllForLeaderboard();

    @Select("SELECT P.* FROM app.player P " +
            "INNER JOIN app.friends F " +
            "ON P.id = F.player_id " +
            "WHERE F.friend_id = #{id} " +
            "ORDER BY P.points DESC " +
            "LIMIT 15")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    List<Player> findAllForLeaderboardFriends(@Param("id") UUID id);

    @Select("SELECT P.* FROM app.player P " +
            "INNER JOIN app.friends F " +
            "ON P.id = F.friend_id " +
            "WHERE F.player_id = #{id} " +
            "ORDER BY P.points DESC " +
            "LIMIT 15")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "points", column = "points"),
            @Result(property = "lastOnline", column = "last_online"),
            @Result(property = "profilePictureUrl", column = "profile_picture_url")
    })
    List<Player> findAllForLeaderboardFriendsByPlayer(@Param("id") UUID id);

    @Update("UPDATE app.player SET " +
            "email = #{email}, nickname = #{nickname}, password = #{password}, " +
            "points = #{points}, last_online = #{lastOnline}, profile_picture_url = #{profilePictureUrl}" +
            " WHERE id = #{id}")
    void update(Player player);

    @Delete("DELETE FROM app.player WHERE id = #{id}")
    void delete(@Param("id") UUID id);
}
