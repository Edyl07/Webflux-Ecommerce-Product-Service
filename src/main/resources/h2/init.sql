create table categories (
    id bigint auto_increment,
    categoryName varchar(50),
    description varchar(100),
    imageUrl varchar(100),
    primary key (id)
);


create table products(
    id bigint auto_increment,
    categoryId bigint,
    name varchar(50),
    description varchar(100),
    price decimal,
    imageUrl varchar(100),
    foreign key (categoryId) references categories(id) on delete cascade
);

 insert into categories
    (categoryName, description, imageUrl)
    values
    ('Electronics', 'Bla Bla', 'https://edyl.tech'),
    ('Sport', 'Bla Bla', 'https://edyl.tech'),
    ('Food', 'Bla Bla', 'https://edyl.tech'),
    ('Grocery', 'Bla Bla', 'https://edyl.tech');