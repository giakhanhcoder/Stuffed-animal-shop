CREATE DATABASE Assignment;

CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY ,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    name NVARCHAR(50) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    address NVARCHAR(100) NOT NULL,
    role INT NOT NULL DEFAULT 2,
	image nvarchar(255)
);


CREATE TABLE product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    price FLOAT NOT NULL,
    description NVARCHAR(255) NOT NULL,
    image NVARCHAR(255) NOT NULL,
    category_id INT NOT NULL FOREIGN KEY REFERENCES category(id)

);


CREATE TABLE category (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);


CREATE TABLE orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_id INT NOT NULL FOREIGN KEY REFERENCES product(id),
    quantity INT NOT NULL,
    purchase_id INT NOT NULL FOREIGN KEY REFERENCES purchase(id),
	price FLOAT NOT NULL
);

CREATE TABLE purchase (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES users(id),
    total FLOAT NOT NULL,
    date DATE NOT NULL
);

--DBCC CHECKIDENT (product, RESEED, 0)
--DBCC CHECKIDENT (orders, RESEED, 0)

INSERT INTO users (username, password, email, name, phone, address, role) 
VALUES ('admin', 'admin', 'admin@admin.com', N'admin', '0123456789', N'admin', 1);

insert into category(name)
values(N'Chó Bông'),
(N'Lợn Bông'),(N'Mèo Bông'),(N'Gấu Bông'),(N'Vịt Bông')




