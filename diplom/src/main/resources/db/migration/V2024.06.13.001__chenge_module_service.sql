DO $$
    BEGIN
        IF EXISTS (
            SELECT 1 FROM information_schema.table_constraints
            WHERE constraint_name = 'module_test_id_fkey' AND table_name = 'module'
        ) THEN
            ALTER TABLE module DROP CONSTRAINT module_test_id_fkey;
        END IF;
    END $$;

ALTER TABLE module DROP COLUMN IF EXISTS test_id;


ALTER TABLE test
    ADD COLUMN IF NOT EXISTS module_id BIGINT;

ALTER TABLE test
    ADD CONSTRAINT test_module_id_fkey
        FOREIGN KEY (module_id) REFERENCES module (id) ON DELETE CASCADE;


ALTER TABLE test DROP COLUMN IF EXISTS scoring;
ALTER TABLE test DROP COLUMN IF EXISTS rating;
ALTER TABLE test ADD COLUMN IF NOT EXISTS test_complete BOOLEAN;


CREATE TABLE IF NOT EXISTS result
(
    id BIGSERIAL PRIMARY KEY,
    total BIGINT,
    correct BIGINT,
    wrong BIGINT,
    correct_percentage BIGINT,
    wrong_percentage BIGINT,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE
);


ALTER TABLE test ADD COLUMN IF NOT EXISTS result_id BIGINT;

ALTER TABLE test
    ADD CONSTRAINT test_result_id_fkey
        FOREIGN KEY (result_id) REFERENCES result (id) ON DELETE CASCADE;