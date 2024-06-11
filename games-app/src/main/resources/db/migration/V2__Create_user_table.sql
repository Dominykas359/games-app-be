CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE player (
    id UUID PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    nickname VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    points INTEGER NOT NULL,
    last_online TIMESTAMP(0)
);
