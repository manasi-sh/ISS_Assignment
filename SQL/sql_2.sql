USE student_db;

-- Stored procedure
DELIMITER $$
CREATE PROCEDURE get_student_by_id (IN input_id INT)
BEGIN
	SELECT * FROM students WHERE student_id = input_id;
END; $$
DELIMITER ;

-- Callable Statement (to call the procedure)
CALL get_student_by_id(2);

-- Prepared statement
PREPARE statement FROM 'SELECT * FROM students WHERE city = ?';
SET @city = 'Thane';
EXECUTE statement USING @city;
DEALLOCATE PREPARE statement; -- To remove statement from memory one we are done using it
