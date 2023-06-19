CREATE TABLE item (
  id INT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  year_Of_Publishing INT,
  genre VARCHAR(50),
  is_Borrowed BOOLEAN,
  is_Reserved BOOLEAN
);
