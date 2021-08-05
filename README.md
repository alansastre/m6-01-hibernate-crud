
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

1. Crear archivo import.sql en src/main/resources (Se importa automáticamente sin añadir nada en la configuracion)
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



## Proyecto Hibernate


* TagColor: una enumeración, podrá ser de tipo BLUE, YELLOW, GREEN, RED.

* Tag: representa una entidad etiqueta con los atributos id, nombre, color (enum TagColor, almacenada como string en base de datos)

* User: representa una entidad usuario con los siguientes atributos id, nombre,
apellido, dni, si está activo sí o no, fecha de nacimiento

* Task: representa una entidad tarea, con los atributos id, título, descripción,
finalizada (sí o no), fecha de entrega LocalDate).

* BillingInfo: representa la información de facturación de un usuario


### Asociaciones:

1. Un usuario tiene muchas tareas, una tarea sólo puede pertenecer a un mismo
usuario a la vez.
	* User: One To Many (mappedBy = "user")
	* Task: Many To One (owner, tiene columna user_id)

2. Una tarea puede tener muchas etiquetas, una etiqueta puede estar en más de
una tarea a la vez.
	* Task: ManyToMany
	* Tag: ManyToMany

3. Un usuario tiene una información de facturación BillingInfo y una información
de facturación sólo puede pertenecer a un mismo usuario.
	* User: OneToOne
	* BillingInfo: OneToOne


## Frameworks:

1. Spring Data JPA
2. Hibernate: HQL, Criteria API, Caché
3. JDBC
4. Base de datos












