INSERT INTO employees(full_name, biography, married) values ('Employee 1', 'Lorem ipsum dolor', true);
INSERT INTO employees(full_name, biography, married) values ('Employee 2', 'Lorem ipsum dolor', true);
-- @Type(type = "yes_no")
-- INSERT INTO employees(full_name, biography, married) values ('Employee 1', 'Lorem ipsum dolor', 'N');
-- INSERT INTO employees(full_name, biography, married) values ('Employee 2', 'Lorem ipsum dolor', 'Y');
-- @Type(type = "true_false")
-- INSERT INTO employees(full_name, biography, married) values ('Employee 1', 'Lorem ipsum dolor', 'T');
-- INSERT INTO employees(full_name, biography, married) values ('Employee 2', 'Lorem ipsum dolor', 'F');
-- @Enumerated(EnumType.STRING)
INSERT INTO employees(full_name, biography, married, `type`) values ('Employee EJEMPLO', 'Lorem ipsum dolor', true, 'SENIOR');