package org.generation.CoffeeKode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // esta anotacions dice que User.java es una entidad de una base de datos y que sus datos persistiran
@Table(name="users")// Especifica que la informacion se guardara en una tabla llamada "usuarios" dentro de mi BD

public class Users {

	@Id //Especifico que es mi llave primaria, y usando este @Id le digo que ese valor es lo que conectara a otras tablas
//Anotaciones enfocadas a decirle a JAVA que esta clase es una entidad de mi BD
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor de este atributo se genera de forma automatica, osea que cada que genere un dato se inserte en una nueva fila. El argumento "strategy" especifica como se genera se valor, cuando susamos el "Generation.Identity" le decimos que el valos se va a agregar mediante una secuencia (el valor autoincrementable de la BD)
	
	@Column(name= "id", unique=true, nullable= false) //  //el nombre de la columna es id, y esta es unica y no nula

	
	
	// 1 Atributos

	
		Long id;
		String username;
		String password;
		String firstname;
		String lastname;
		String birthdate;
		
		
	// 2 Constructores
		
			
	public Users(Long id, String username, String password, String firstname, String lastname, String birthdate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
		
	// 3 constructor vacio
	public Users() {
	}

	
	// 4 Getters and Setters
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	
	
	// 4 toString
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", birthdate=" + birthdate + "]";
	}

	
	
	
}
	

		
		
		