
## JPA - Hibernate

* Java Persistence API (JPA): Especificación (Interfaces y clases)
* Hibernate es una implementación de JPA (Implementa las interfaces de JPA)

Hibernate es un conjunto de herramientas de persistencia.

Es una herramienta Object Relational Mapping (ORM): permite ahorrar 
un 60-80% del tiempo al automatizar el mapeo.


Niveles de abstracción:

1. Spring Data JPA
2. Hibernate (JPA)
3. JDBC
4. Base de datos (H2, MySQL, MariaDB, PostgreSQL...)


## Entidades

Es el concepto central de Hibernate.

Una entidad es una clase que estará mapeada contra una tabla de la base de datos. 

Modelos, Entidades, Clases dominio, Clases de datos.

Se les reconoce por llevar la anotación @Entity o estar configuradas a través de XML.


## Importar datos

1. Crear archivo import.sql en src/main/resources (Se ejecuta automáticamente)
2. Crear archivo data.sql en src/main/resources (Hay que especificarlo en .cfg.xml para que lo inserte) en la propiedad hibernate.hbm2ddl.import_file si se lee este entonces no se lee el import.sql automáticamente

En Spring el data.sql se inserta automáticamente, es Spring quien lo inserta.


## Conceptos

1. Tipos de datos
2. CRUD sobre una sola entidad
3. HQL
4. Asociaciones entre entidades:
	* One To One
	* One To Many
	* Many To One
	* Many To Many
5. Criteria API


## Esquema

Angular --> API REST Controladores Java --> Servicio --> DAO


## Métodos CRUD

* find - Retrieve
* save - Create
* merge - Update
* delete - Delete

## Asociaciones

* One To One


## Inicialización tardía: Lazy

Recuperar una empresa:

1. fetch = FetchType.EAGER:
	* Se recuperan los employees siempre
	
2. Dejar fetch lazy (Por defecto) y recuperar la empresa sin los empleados (find normal)
	* Consultas de cif, name, capital
	
3. Dejar fetch lazy (Por defecto) y ecuperar la empresa con los empleados: (HQL join fetch employees)
	* Consultas de los empleados + informacion de la empresa
	
4. (Otra posibilidad)  Abrir nueva sesión, refrescar la company, ejecutar getEmployees()











