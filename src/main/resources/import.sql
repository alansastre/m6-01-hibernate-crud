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
-- one to one
INSERT INTO directions (city, country, postal_code, street) VALUES('Madrid', 'Spain', '28018', 'Avenida independencia');
INSERT INTO employees(full_name, biography, married, id_direction) values ('Employee con Direccion', 'Lorem ipsum dolor', true, 1);
-- many to one
INSERT INTO companies (capital, cif, name, start_date) VALUES(3500, 'B2345', 'Cosmic developments', '2020-12-30');
INSERT INTO directions (city, country, postal_code, street) VALUES('Madrid', 'Spain', '28018', 'Avenida independencia2');
INSERT INTO employees(full_name, biography, married, id_company, id_direction) values ('Employee1 con Empresa', 'Lorem ipsum dolor', true, 1, 2);
-- one to many: añado un empleado mas para verificar que one company tiene many empleados:
INSERT INTO employees(full_name, biography, married, id_company) values ('Employee2 con Empresa', 'Lorem ipsum dolor', true, 1);