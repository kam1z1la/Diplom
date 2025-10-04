CREATE TABLE IF NOT EXISTS event
(
    id      BIGSERIAL,
    title    varchar(250),
    description varchar(500),
    date TIMESTAMP WITHOUT TIME ZONE,
    link varchar(500),
    course_id BIGINT,
    primary key (id),
    foreign key (course_id) references course (id) on delete cascade
);