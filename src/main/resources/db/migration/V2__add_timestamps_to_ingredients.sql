ALTER TABLE ingredients
    ADD created_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE ingredients
    ADD updated_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE ingredients
    ALTER COLUMN created_at SET NOT NULL;

ALTER TABLE ingredients
    ALTER COLUMN updated_at SET NOT NULL;