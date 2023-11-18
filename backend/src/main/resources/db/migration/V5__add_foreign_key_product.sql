ALTER TABLE product
ADD COLUMN user_id INT,
ADD CONSTRAINT fk_user
  FOREIGN KEY (user_id)
  REFERENCES user(id);