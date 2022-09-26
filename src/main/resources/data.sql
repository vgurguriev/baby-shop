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

INSERT INTO products(id, name, price, picture_url, color, category_id, brand_id, description, sales)
VALUES (1, 'kolichka', 20, 'https://s13emagst.akamaized.net/products/37730/37729824/images/res_72b0911ef1b50d4a8968cdc6b8c88df1.jpg', 'RED', 1, 1, 'super qkata koli4ka', 0),
       (2, 'Stroller Kikka Boo', 799, 'https://bebeland.net/public/products/detska-kombinirana-kolichka-2v1-tiara-kikkaboo-beige-2.jpg', 'BEIGE', 1, 3, 'stroller kikka boo beige', 0),
       (3, 'Stroller Chippolino Blue', 1000, 'https://cdn.ozone.bg/media/catalog/product/cache/1/image/400x498/a4e40ebdc3e371adff845072e1c73f37/c/h/89ccccf93701db31a344f8c225d4ce1f/detska-kolichka-s-transformirasht-se-kosh-chipolino-noa---sinya-32.jpg', 'BLUE', 1, 2, 'stroller chippolino blue', 0),
       (4, 'Stroller Lorelli', 678, 'https://s13emagst.akamaized.net/products/29146/29145002/images/res_6023f63c84f0956d5c76d7ddeb3e07aa.jpg', 'RED', 1, 1, 'stroller lorelli', 0),
       (5, 'Music Toy', 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToezl7yoIfN4HiSbfl0HwqKrOjhWGnJUO17Q&usqp=CAU', 'WHITE', 5, 1, 'mucis toy', 0),
       (6, 'Elephant', 15, 'https://www.igrachka.com/uploads/images/original/niny-sladkiyat-slon-kaleo-igrachka-za-bebe_110066.jpg', 'BLUE', 5, 2, 'elephant', 0),
       (7, 'Fun Toy', 13, 'https://www.igrachka.com/uploads/images/original/niny-aktivna-topka-nini-igrachka-za-bebe_110086.jpg', 'RED', 5, 3, 'funny toy', 0),
       (8, 'Shark Bath Toy', 3, 'https://www.moliv.bg/uploads/products/2022/47306591943.jpg', 'YELLOW', 5, 1, 'yellow swimming shark', 0),
       (9, 'Fashion Baby', 40, 'https://coin-product.cam/78815/1_%D0%9D%D0%BE%D0%B2%D0%B0-%D0%BB%D1%8F%D1%82%D0%BD%D0%B0-%D0%B4%D0%B5%D1%82%D1%81%D0%BA%D0%B8-%D0%B4%D1%80%D0%B5%D1%85%D0%B8-%D0%BC%D0%BE%D0%BC%D1%87%D0%B5%D1%82%D0%B0-wp-upload/images.jpeg', 'BEIGE', 3, 1, 'fashion baby', 0),
       (10, 'Baby Girl Dress', 37, 'https://www.bebemarket.bg/image/catalog/gd66/105-bebemarket_summer-clothing-babies-Cotton-Newborn-Baby-Clothes-Set-Baby-Summer-Clothes-Cartoon-Girl-Boys-Baby-Boy-Fit.jpg', 'PINK', 3, 2, 'beautful dress for baby girl', 0),
       (11, 'Baby Costume White', 20, 'https://frankfurt.apollo.olxcdn.com/v1/files/fzfwj8mdg8se2-BG/image;s=200x0;q=50', 'WHITE', 3, 3, 'white costume', 0),
       (12, 'Baby Twins White', 33, 'https://wearplatinum.support/asset/mouse/micro/51047-bebeshki-drehi-za-bebeta-novorodeni-bebeta-momcheta-momicheta-momicheta-s-ks-rkav-bliznaci-drehi-za-bebeta-novorodeni.jpg', 'WHITE', 3, 1, 'white twin B', 0);
