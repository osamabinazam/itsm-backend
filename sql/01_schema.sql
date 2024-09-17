DROP TABLE IF EXISTS site_assignments;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS sites;
Drop TABLE IF EXISTS users;







-- Users Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,  -- Roles: CO, TGL, RM, PM
    supervisor_id INT,
    CONSTRAINT fk_supervisor
        FOREIGN KEY (supervisor_id) REFERENCES users(user_id) ON DELETE SET NULL
);

-- Sites Table
CREATE TABLE sites (
    site_id SERIAL PRIMARY KEY,
    site_name VARCHAR(255) NOT NULL,
    site_code VARCHAR(50)  NOT NULL
);

-- Site Assignments Table
CREATE TABLE site_assignments (
    assignment_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    site_id INT NOT NULL,
    start_date DATE ,
    end_date DATE,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_site
        FOREIGN KEY (site_id) REFERENCES sites(site_id) ON DELETE CASCADE
);

-- Requests Table
CREATE TABLE requests (
    request_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,  -- The CO who creates the request
    site_id INT NOT NULL,  -- The site where the issue is reported
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,  -- Status of the request (e.g., PENDING, APPROVED, REJECTED)
    type VARCHAR(50) NOT NULL , -- Type of the request
    fault_description TEXT NOT NULL,
    image_paths TEXT,  -- JSON or comma-separated paths to attached images
    forwarded_to INT,  -- The user who forwarded the request
    verified_by INT,  -- The TGL user who verifies the request
    approved_by INT,  -- The RM or PM user who approves the request
    current_level VARCHAR(50) NOT NULL,  -- Tracks the current level: CO, TGL, RM, PM
    forwarded_by INT,  -- The user who forwarded the request
    next_assignee INT,  -- The next user responsible for the request
    CONSTRAINT fk_user_request
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_site_request
        FOREIGN KEY (site_id) REFERENCES sites(site_id) ON DELETE CASCADE,
    CONSTRAINT fk_forwarded_to
        FOREIGN KEY (forwarded_to) REFERENCES users(user_id) ON DELETE SET NULL,
    CONSTRAINT fk_verified_by
        FOREIGN KEY (verified_by) REFERENCES users(user_id) ON DELETE SET NULL,
    CONSTRAINT fk_approved_by
        FOREIGN KEY (approved_by) REFERENCES users(user_id) ON DELETE SET NULL,
    CONSTRAINT fk_forwarded_by
        FOREIGN KEY (forwarded_by) REFERENCES users(user_id) ON DELETE SET NULL,
    CONSTRAINT fk_next_assignee
        FOREIGN KEY (next_assignee) REFERENCES users(user_id) ON DELETE SET NULL
);
-- Indexes for optimization
CREATE INDEX idx_user_role ON users(role);
CREATE INDEX idx_request_current_level ON requests(current_level);
CREATE INDEX idx_request_status ON requests(status);
