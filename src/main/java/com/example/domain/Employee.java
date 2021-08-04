package com.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;


@Entity
// @DynamicUpdate(value = true) // para que se actualicen unica y exclusivamente aquellos campos que han sido modificados
@Table(name="employees")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	// atributos propios
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="full_name", unique = true, nullable=false)
	private String fullName;
	
	@Column(name="biography", length = 300)
	private String biography;
	
	// @Type(type = "yes_no") // cambia el cómo se almacena boolean en la base de datos será char(1) por defecto era bit(1)
	// @Type(type = "true_false") 
	private Boolean married; 
	
	private Integer age;
	
	private Double salary;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="register_date")
	private LocalDateTime registerDate;
	
	//@Enumerated(EnumType.ORDINAL) // se almacena como número empezando en 0
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@ElementCollection
	private List<String> nicknames = new ArrayList<>();
	 
	// asociaciones con otras entidades
	// Uno a Uno
	@OneToOne // owner
	@JoinColumn(name = "id_direction", foreignKey = @ForeignKey(name = "fk_employee_direction")) // opcional
	private Direction direction;
	
	// company
	@ManyToOne
	private Company company;
	
	
	
	// constructores
	
	
	public Employee() {}
	
	
	public Employee(Long id, String fullName, String biography, Boolean married) {
		this.id = id;
		this.fullName = fullName;
		this.biography = biography;
		this.married = married;
	}
	
	



	public Employee(Long id, String fullName, String biography, Boolean married, Integer age, Double salary,
			LocalDate birthDate, LocalDateTime registerDate, EmployeeType type) {
		this.id = id;
		this.fullName = fullName;
		this.biography = biography;
		this.married = married;
		this.age = age;
		this.salary = salary;
		this.birthDate = birthDate;
		this.registerDate = registerDate;
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	public String getFullName() {
		return fullName;
	}


	public String getBiography() {
		return biography;
	}


	public Boolean getMarried() {
		return married;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public void setMarried(Boolean married) {
		this.married = married;
	}
	
	


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public LocalDateTime getRegisterDate() {
		return registerDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	

	public Integer getAge() {
		return age;
	}


	public Double getSalary() {
		return salary;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}

	

	public EmployeeType getType() {
		return type;
	}


	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	


	public List<String> getNicknames() {
		return nicknames;
	}


	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}
	
	


	public Direction getDirection() {
		return direction;
	}


	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", biography=" + biography + ", married=" + married
				+ ", age=" + age + ", salary=" + salary + ", birthDate=" + birthDate + ", registerDate=" + registerDate
				+ "]";
	}




	
	
	
}
