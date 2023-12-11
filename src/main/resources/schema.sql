create table if not exists product(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    productName varchar(255),
    price INT
);

create table if not exists review(
    id INT PRIMARY KEY AUTO_INCREMENT,
    reviewContent varchar(255), 
    rating INT,
    productId INT,
    FOREIGN KEY (productId) REFERENCES product(productId)
);