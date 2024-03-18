-- Создание таблицы menu_item с внешним ключом на restaurant_id
CREATE TABLE menu_item (
                           id BIGSERIAL PRIMARY KEY,
                           description VARCHAR(255),
                           name VARCHAR(255),
                           price NUMERIC(38,2),
                           restaurant_id BIGINT,
                           FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

-- Создание таблицы restaurant
CREATE TABLE restaurant (
                            id BIGSERIAL PRIMARY KEY,
                            email VARCHAR(255),
                            name VARCHAR(255)
);

-- Создание таблицы restaurant_menu_items с двумя внешними ключами
CREATE TABLE restaurant_menu_items (
                                       restaurant_id BIGINT NOT NULL,
                                       menu_item_id BIGINT NOT NULL,
                                       PRIMARY KEY (restaurant_id, menu_item_id), -- Создаем составной первичный ключ
                                       FOREIGN KEY (restaurant_id) REFERENCES restaurant(id),
                                       FOREIGN KEY (menu_item_id) REFERENCES menu_item(id)
);
