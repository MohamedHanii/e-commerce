ALTER TABLE product
    CHANGE name title VARCHAR(255) NOT NULL,
    ADD category VARCHAR(255),
    ADD brand VARCHAR(255),
    ADD stock_quantity INT;