INSERT INTO supervisor (name, email)
VALUES ('john', 'john@mail.dk'),
       ('bob', 'bob@mail.dk'),
       ('leonord', 'leonord@mail.dk');

INSERT INTO student (name, email, supervisor_id)
VALUES ('kim', 'kim@mail.dk', 1),
       ('frank', 'frank@mail.dk', 1),
       ('lone', 'lone@mail.dk', 1),
       ('tim', 'tim@mail.dk', 2),
       ('henry', 'henry@mail.dk', 2),
       ('franka', 'franka@mail.dk', 3)