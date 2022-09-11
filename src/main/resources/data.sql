INSERT INTO roles(id, role)
VALUES (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO base_categories(id, base_category_name)
VALUES (1, 'BABY'),
       (2, 'MOMMY');

INSERT INTO categories(id, name, base_category_id)
VALUES (1, 'STROLLERS', 1),
       (2, 'CAR_SEATS', 1),
       (3, 'BABY_CLOTHES', 1),
       (4, 'BABY_COSMETICS', 1),
       (5, 'TOYS', 1),
       (6, 'BREAST_MILK_PUMPS', 2),
       (7, 'MATERNITY_CLOTHES', 2),
       (8, 'MOMMY_COSMETICS', 2),
       (9, 'MILK_CONTAINERS', 2);

INSERT INTO brands(id, name)
VALUES (1, 'LORELLY'),
       (2, 'CHIPOLINO'),
       (3, 'KIKKABOO');

INSERT INTO products(id, name, price, picture_url, color, category_id, brand_id, description)
VALUES (1, 'kolichka', 20, 'https://s13emagst.akamaized.net/products/37730/37729824/images/res_72b0911ef1b50d4a8968cdc6b8c88df1.jpg', 'RED', 1, 1, 1)
