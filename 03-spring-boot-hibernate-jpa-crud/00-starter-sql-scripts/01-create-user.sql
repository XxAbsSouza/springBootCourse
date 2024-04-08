-- Drop user first if they exist
DROP ROLE IF EXISTS springstudent;

-- Now create user with prop privileges
CREATE ROLE springstudent WITH LOGIN PASSWORD 'springstudent';

-- Grant privileges
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO springstudent;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO springstudent;
