ALTER TABLE result DROP CONSTRAINT result_test_id_fkey;
ALTER TABLE result DROP COLUMN test_id;

ALTER TABLE result
    ADD COLUMN test_id BIGINT;

ALTER TABLE result
    ADD CONSTRAINT result_test_id_fkey
        FOREIGN KEY (test_id) REFERENCES test (id) ON DELETE CASCADE;