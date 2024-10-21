CREATE TABLE IF NOT EXISTS account_details (
                                               id UUID PRIMARY KEY,
                                               username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    city VARCHAR(100),
    account_type VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS companies (
                                         id UUID PRIMARY KEY,
                                         account_details_id UUID,
                                         employee_count INT,
                                         rating FLOAT,
                                         FOREIGN KEY (account_details_id) REFERENCES account_details(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY,
                                     account_details_id UUID,
                                     FOREIGN KEY (account_details_id) REFERENCES account_details(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS tech_stacks (
                                           id UUID PRIMARY KEY,
                                           name VARCHAR(100),
    description TEXT,
    image TEXT
    );

CREATE TABLE IF NOT EXISTS job_posters (
                                           id UUID PRIMARY KEY,
                                           title VARCHAR(255) NOT NULL,
    description TEXT,
    city VARCHAR(100),
    posted_date DATE,
    valid_till DATE,
    company_id UUID,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS applications (
                                            id UUID PRIMARY KEY,
                                            user_id UUID,
                                            jobposter_id UUID,
                                            application_date_time TIMESTAMP,
                                            status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (jobposter_id) REFERENCES job_posters(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS jobposter_techstack (
                                                   jobposter_id UUID,
                                                   techstack_id UUID,
                                                   PRIMARY KEY (jobposter_id, techstack_id),
    FOREIGN KEY (jobposter_id) REFERENCES job_posters(id) ON DELETE CASCADE,
    FOREIGN KEY (techstack_id) REFERENCES tech_stacks(id) ON DELETE CASCADE
    );

INSERT INTO account_details (id, username, password, name, email, address, phone_number, city, account_type)
VALUES ('b3e56f5e-2a58-4a91-8194-ecc233cf4956', 'john_doe', '$2a$10$ro/mUzAnvooEAxwH9IBdXuibsQM94tV7auni4X4mULf9xCg8HoZeG', 'John Doe', 'john.doe@example.com', '123 Main St', '+1234567890', 'Leuven', 'USER');
--this is the encrypted password
