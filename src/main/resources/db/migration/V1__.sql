CREATE TABLE ingredients
(
    id                UUID             NOT NULL,
    name              VARCHAR(255)     NOT NULL,
    calories_per_100g DOUBLE PRECISION NOT NULL,
    protein_per_100g  DOUBLE PRECISION NOT NULL,
    carbs_per_100g    DOUBLE PRECISION NOT NULL,
    fat_per_100g      DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_ingredients PRIMARY KEY (id)
);