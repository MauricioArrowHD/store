
CREATE TABLE users (
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE products (
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    price INT4 NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE orders (
    id UUID NOT NULL,
    user_id UUID NOT NULL,
    product_id UUID NOT NULL,
    quantity INT4 NOT NULL,
    order_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id),
    CONSTRAINT fk_orders_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_orders_product_id FOREIGN KEY (product_id) REFERENCES products (id)
);