-- Normalization
-- 1NF (Remove Repeating Groups) - students table is in 1NF
-- 2NF (Remove Partial Dependency) - achieved by creating separate courses table and linking student to courses in a separate enrolled table

-- 3NF (Remove Transitive Dependency) - city and state will depend only on the primary key (city_id) - duplication avoided)
CREATE TABLE cities (
    city_id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(100),
    state_name VARCHAR(100)
);

INSERT INTO cities (city_name, state_name)
VALUES ('Mumbai', 'Maharashtra'),
       ('Thane', 'Maharashtra'),
       ('Pune', 'Maharashtra');

ALTER TABLE students
ADD COLUMN city_id INT,
ADD FOREIGN KEY (city_id) REFERENCES cities(city_id);

SET SQL_SAFE_UPDATES = 0; -- to facilitate update using column apart from indexes
UPDATE students SET city_id = 1 WHERE city = 'Mumbai'; 
UPDATE students SET city_id = 2 WHERE city = 'Thane';
UPDATE students SET city_id = 3 WHERE city = 'Pune';

ALTER TABLE students DROP COLUMN city; -- city and state transferred to new table and linked using city_id