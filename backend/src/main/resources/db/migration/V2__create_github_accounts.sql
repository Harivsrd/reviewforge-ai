CREATE TABLE github_accounts (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    github_user_id VARCHAR(100) UNIQUE NOT NULL,

    github_username VARCHAR(100) UNIQUE NOT NULL,

    display_name VARCHAR(255),

    avatar_url TEXT,

    access_token TEXT,

    connected BOOLEAN NOT NULL DEFAULT TRUE,

    connected_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    user_id UUID UNIQUE NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_github_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);