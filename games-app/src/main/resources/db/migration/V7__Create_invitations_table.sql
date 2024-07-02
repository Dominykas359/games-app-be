CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE invitations(
    id UUID PRIMARY KEY,
    player_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    friend_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    CONSTRAINT unique_invitation UNIQUE (player_id, friend_id)
);