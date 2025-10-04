ALTER TABLE module DROP CONSTRAINT module_test_id_fkey;
ALTER TABLE module DROP COLUMN test_id;

ALTER TABLE test
    ADD COLUMN module_id BIGINT;

ALTER TABLE test
    ADD CONSTRAINT test_module_id_fkey
        FOREIGN KEY (module_id) REFERENCES module (id) ON DELETE CASCADE;

ALTER TABLE test DROP COLUMN scoring;
ALTER TABLE test DROP COLUMN rating;
ALTER TABLE test ADD COLUMN test_complete boolean;

CREATE TABLE IF NOT EXISTS result
(
    id      BIGSERIAL,
    total    BIGINT,
    correct BIGINT,
    wrong  BIGINT,
    correct_percentage BIGINT,
    wrong_percentage BIGINT,
    user_id BIGINT,
    primary key (id),
    foreign key (user_id) references "user" (id) on delete cascade
);

ALTER TABLE test ADD COLUMN result_id BIGINT;

ALTER TABLE test
    ADD CONSTRAINT test_result_id_fkey
        FOREIGN KEY (result_id) REFERENCES result (id) ON DELETE CASCADE;