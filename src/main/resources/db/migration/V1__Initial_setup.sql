CREATE TABLE student (
    id BIGSERIAL,
    first_name VARCHAR(40) NOT NULL ,
    last_name VARCHAR(40) NOT NULL,
    email VARCHAR(319) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE subject(
    id BIGSERIAL,
    subject_name VARCHAR(50) NOT NULL,
    marks_obtained DOUBLE PRECISION NOT NULL,
    student_id BIGINT NOT NULL ,
    CONSTRAINT student_id_fk FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT marks_obtained_check CHECK ( marks_obtained >= 0 AND marks_obtained <=12 ),
    PRIMARY KEY (id)
);

CREATE TABLE address(
    id BIGSERIAL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    student_id BIGINT NOT NULL ,
    CONSTRAINT student_id_fk FOREIGN KEY (student_id) REFERENCES student(id),
    PRIMARY KEY (id)
);