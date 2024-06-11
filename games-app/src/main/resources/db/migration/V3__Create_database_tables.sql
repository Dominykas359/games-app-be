CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE friends(
    id UUID PRIMARY KEY,
    player_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    friend_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    friends_since DATE,
    CONSTRAINT unique_friendship UNIQUE (player_id, friend_id)
);
CREATE TABLE games(
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE game_points(
    id UUID PRIMARY KEY,
    player_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    game_id UUID NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    points INTEGER NOT NULL
);