CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users(

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    full_name VARCHAR(100) NOT NULL,

    email VARCHAR(255) UNIQUE NOT NULL,

    password VARCHAR(255) NOT NULL,

    provider VARCHAR(30),

    github_id BIGINT,

    avatar_url TEXT,

    created_at TIMESTAMP,

    updated_at TIMESTAMP

);