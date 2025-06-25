-- Create database
CREATE DATABASE student_db;
USE student_db;

-- Create tables
CREATE TABLE students (
	student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    age INT,
    gender ENUM('Male', 'Female'),
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50),
    registration_date DATE DEFAULT (CURRENT_DATE));

CREATE TABLE courses (
	course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    credits INT CHECK (credits >= 1 AND credits <= 5));
    
CREATE TABLE enrolled (
	enroll_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    grade CHAR(2),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id));

-- Insert into tables
INSERT INTO students (first_name, last_name, age, gender, email, city) VALUES 
	('ABC', 'XYZ', 17, 'Male', 'abc@email.com', 'Thane'),
    ('DEF', 'UVW', 20, 'Female', 'def@email.com', 'Delhi'),
    ('GHI', 'RST', 22, 'Female', 'ghi@email.com', 'Pune');

INSERT INTO courses (course_name, credits) VALUES
	('Course1', 3),
    ('Course2', 4),
    ('Course3', 3);

INSERT INTO enrolled (student_id, course_id, grade) VALUES
	(1, 2, 'A'),
    (1, 3, 'B'),
    (2, 1, 'A'),
    (3, 2, 'C');

-- Select Query with different keywords
SELECT * FROM students LIMIT 2;
SELECT DISTINCT city FROM students;
SELECT first_name AS 'First Name', last_name AS 'LAST NAME' FROM students WHERE city = 'Thane' AND age<=20;
SELECT first_name, last_name FROM students WHERE city = 'Thane' OR age<=20;
SELECT * FROM students ORDER BY last_name DESC;
SELECT * FROM students WHERE first_name LIKE 'A%';
SELECT * FROM students WHERE email LIKE '%.com';
SELECT first_name FROM students WHERE city IN ('Mumbai', 'Thane');
SELECT first_name FROM students WHERE age BETWEEN 20 AND 25;

-- Update Query
UPDATE students SET city = 'Mumbai' WHERE student_id = 2;

-- Delete Query
DELETE FROM enrolled WHERE student_id = 3 AND course_id = 2;

-- Joins (Inner, Right, Left, Full)
-- Full Join is not supported in MySQL, so to achieve that we need to perform union of left and right join
SELECT first_name, last_name FROM students s
INNER JOIN enrolled e ON e.student_id = s.student_id
INNER JOIN courses c ON c.course_id = e. course_id; 

SELECT first_name, last_name FROM students s
LEFT JOIN enrolled e ON e.student_id = s.student_id
LEFT JOIN courses c ON c.course_id = e. course_id; 

SELECT first_name, last_name FROM students s
RIGHT JOIN enrolled e ON e.student_id = s.student_id
RIGHT JOIN courses c ON c.course_id = e. course_id; 

SELECT first_name, last_name FROM students s
LEFT JOIN enrolled e ON e.student_id = s.student_id
LEFT JOIN courses c ON c.course_id = e. course_id
UNION
SELECT first_name, last_name FROM students s
RIGHT JOIN enrolled e ON e.student_id = s.student_id
RIGHT JOIN courses c ON c.course_id = e. course_id;

-- Insert into Select (Copy columns from one table to another table)
INSERT INTO students (first_name, last_name, age, gender, email, city) 
SELECT 'Demo Name', 'Demo Surname', 17, 'Male', 'demo@email.com', 'Thane';

-- Create index
CREATE INDEX index_city ON students(city);
SHOW INDEXES FROM students;

-- Drop
DROP INDEX index_city ON students;

-- Alter Table
ALTER TABLE students ADD COLUMN phone_no VARCHAR(15);
ALTER TABLE students ADD COLUMN address VARCHAR(100);

-- Null values
INSERT INTO students (first_name, last_name, age, gender, email, city, phone_no) VALUES 
('JKL', NULL, 18, 'Male', 'jkl@email.com', NULL, phone_no = '9876543219');
INSERT INTO students (first_name, last_name, age, gender, email, city, phone_no, address) VALUES 
('MNO', NULL, 23, 'Female', 'mno@email.com', 'Mumbai', phone_no = '9876543219', '501, ABC Colony');

-- Views
CREATE VIEW enrolled_course AS
SELECT s.first_name, s.last_name, c.course_name
FROM students s 
JOIN enrolled e ON s.student_id = e.student_id
JOIN courses c ON c.course_id = e.course_id;

SELECT * FROM enrolled_course;

-- Group by, Having
SELECT city, COUNT(*) AS total_students
FROM students GROUP BY city HAVING COUNT(*)>=1;

-- Null Functions
SELECT first_name, IFNULL(city, 'Unknown') AS city_name FROM students;
SELECT first_name, COALESCE(address, city, 'Unknown') AS address FROM students;
