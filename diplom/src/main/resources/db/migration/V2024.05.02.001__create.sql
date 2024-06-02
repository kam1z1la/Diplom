CREATE TABLE IF NOT EXISTS category
(
    id   BIGSERIAL,
    name VARCHAR(300) NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS token
(
    id                     BIGSERIAL,
    access_token           VARCHAR(300) NOT NULL,
    data_access_expires_at TIMESTAMP WITHOUT TIME ZONE,
    issued_at              TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);

create unique index token_index on token (id);

CREATE TABLE IF NOT EXISTS "user"
(
    id            BIGSERIAL,
    first_name    VARCHAR(30)  NOT NULL,
    last_name     VARCHAR(30)  NOT NULL,
    mail          VARCHAR(100) unique,
    phone_number  VARCHAR(30) unique,
    password      VARCHAR(300) not null,
    refresh_token VARCHAR(500),
    token_id      BIGINT unique,
    photo         VARCHAR(500) unique,
    primary key (id),
    foreign key (token_id) references token (id) on delete cascade
);

create unique index user_index on "user" (id);

CREATE TABLE IF NOT EXISTS role
(
    id   BIGSERIAL,
    name VARCHAR(30) NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    primary key (user_id, role_id),
    foreign key (user_id) references "user" (id) on delete cascade,
    foreign key (role_id) references role (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS experts
(
    id          BIGSERIAL,
    user_id     BIGINT,
    description VARCHAR(300) NOT NULL,
    primary key (id),
    foreign key (user_id) references "user" (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS course
(
    id           BIGSERIAL,
    name         VARCHAR(200) NOT NULL,
    description  text         NOT NULL,
    category_id  BIGINT,
    course_cover VARCHAR(500) NOT NULL,
    is_paid      BOOLEAN,
    price        DECIMAL(10, 2),
    primary key (id),
    foreign key (category_id) references category (id) on delete cascade
);

create unique index course_index on course (id);

CREATE TABLE IF NOT EXISTS user_course
(
    user_id  bigint NOT NULL,
    course_id bigint NOT NULL,
    primary key (user_id, course_id),
    foreign key (user_id) references "user" (id) on delete cascade,
    foreign key (course_id) references course (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS course_experts
(
    course_id  bigint NOT NULL,
    experts_id bigint NOT NULL,
    primary key (course_id, experts_id),
    foreign key (course_id) references course (id) on delete cascade,
    foreign key (experts_id) references experts (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS target_audience
(
    id          BIGSERIAL,
    name        VARCHAR(150) NOT NULL,
    description VARCHAR(300) NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS course_target_audience
(
    course_id          bigint NOT NULL,
    target_audience_id bigint NOT NULL,
    primary key (course_id, target_audience_id),
    foreign key (course_id) references course (id) on delete cascade,
    foreign key (target_audience_id) references target_audience (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS test
(
    id      BIGSERIAL,
    name    VARCHAR(200) NOT NULL,
    scoring double precision,
    rating  BIGINT,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS question
(
    id       BIGSERIAL,
    question VARCHAR(500) NOT NULL,
    test_id  BIGINT,
    primary key (id),
    foreign key (test_id) references test (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS answer
(
    id          BIGSERIAL,
    answer      VARCHAR(500) NOT NULL,
    is_correct  BOOLEAN,
    question_id BIGINT,
    primary key (id),
    foreign key (question_id) references question (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS module
(
    id        BIGSERIAL,
    name      VARCHAR(200) NOT NULL,
    test_id   BIGINT,
    course_id BIGINT,
    primary key (id),
    foreign key (test_id) references test (id) on delete cascade,
    foreign key (course_id) references course (id) on delete cascade
);

create unique index module_index on module (id);

CREATE TABLE IF NOT EXISTS topics
(
    id        BIGSERIAL,
    name      VARCHAR(200) NOT NULL,
    text      text         NOT NULL,
    links     VARCHAR(500),
    module_id BIGINT,
    primary key (id),
    foreign key (module_id) references module (id) on delete cascade
);