CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO tasks (title, description, status, created_at)
VALUES
    ('Deitar', 'Deitar', 'PENDING', CURRENT_TIMESTAMP),
    ('Deitar', 'Deitar', 'IN_PROGRESS', CURRENT_TIMESTAMP),
    ('Deitar', 'Deitar', 'COMPLETED', CURRENT_TIMESTAMP);