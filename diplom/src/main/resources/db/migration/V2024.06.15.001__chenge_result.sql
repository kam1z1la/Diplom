DO $$
    BEGIN
        IF EXISTS (
            SELECT 1 FROM information_schema.table_constraints
            WHERE constraint_name = 'result_test_id_fkey' AND table_name = 'result'
        ) THEN
            ALTER TABLE result DROP CONSTRAINT result_test_id_fkey;
        END IF;
    END $$;


ALTER TABLE result DROP COLUMN IF EXISTS test_id;
ALTER TABLE result ADD COLUMN IF NOT EXISTS test_id BIGINT;

ALTER TABLE result
    ADD CONSTRAINT result_test_id_fkey
        FOREIGN KEY (test_id) REFERENCES test (id) ON DELETE CASCADE;