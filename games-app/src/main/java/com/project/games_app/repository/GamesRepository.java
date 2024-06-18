package com.project.games_app.repository;

import com.project.games_app.models.Game;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface GamesRepository {

    @Insert("INSERT INTO app.games " +
            "(id, title, picture_url) " +
            "VALUES(#{id}, #{title}, #{pictureUrl})")
    void insert(Game game);

    @Select("SELECT * FROM app.games WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "pictureUrl", column = "picture_url")
    })
    Optional<Game> findById(@Param("id") UUID id);

    @Select("SELECT * FROM app.games ORDER BY title ASC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "pictureUrl", column = "picture_url")
    })
    List<Game> findAll();

    @Update("UPDATE app.games SET " +
            "title = #{title} WHERE id = #{id}")
    void update(Game game);

    @Delete("DELETE FROM app.games WHERE id = #{id}")
    void delete(@Param("id") UUID id);
}
