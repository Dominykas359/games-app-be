package com.project.games_app.repository;

import com.project.games_app.models.GamePoints;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface GamePointsRepository {

    @Insert("INSERT INTO app.game_points " +
            "(id, player_id, game_id, points) " +
            "VALUES(#{id}, #{playerId}, #{gameId}, #{points})")
    void insert(GamePoints gamePoints);

    @Update("UPDATE app.game_points SET " +
            "points = #{points} WHERE id = #{id}")
    void update(GamePoints gamePoints);

    @Delete("DELETE FROM app.game_points WHERE id = #{id}")
    void delete(@Param("id") UUID id);

    @Select("SELECT * FROM app.game_points WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "gameId", column = "game_id"),
            @Result(property = "points", column = "points")
    })
    Optional<GamePoints> findById(@Param("id") UUID id);

    @Select("SELECT * FROM app.game_points WHERE player_id = #{playerId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "gameId", column = "game_id"),
            @Result(property = "points", column = "points")
    })
    List<GamePoints> findByPlayerId(@Param("playerId") UUID playerId);

    @Select("SELECT * FROM app.game_points WHERE game_id = #{gameId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "playerId", column = "player_id"),
            @Result(property = "gameId", column = "game_id"),
            @Result(property = "points", column = "points")
    })
    List<GamePoints> findByGameId(@Param("gameId") UUID gameId);
}
