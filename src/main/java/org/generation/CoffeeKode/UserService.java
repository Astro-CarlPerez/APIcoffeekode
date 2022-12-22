package org.generation.CoffeeKode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
	
	
	//constante para instanciar objetos del tipo UserRepository
		private UserRepository userRepository;
		
		
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//Metodo GET para traer todos los usuarios
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	//Metodo GET para un usuario por id
	public User getUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(
				()-> new IllegalStateException("El usuario con el id solicitado no existe")
				);
	}

	//Metodo DELETE para un usuario por id
		public void deleteUser(Long userId) {
			if(userRepository.existsById(userId)) { //primero reviso que el user exista
				userRepository.deleteById(userId); //si existe, lo borro
			}else { //si recibo algo diferente a un numero, disparo la excepcion
				throw new IllegalStateException("El usuario con el id solicitado no existe, revisa que estes ingresando un valor numerico");
			}
		}

	// Metodo POST Para agregar un usuario
	public void addUser(User user) { //guardando entidades del tipo usuario
		Optional<User> userByName = userRepository.findByUsername(user.getUsername()); //Sacando el valor de mi BD y lo pongo en una variable temporal (como en el foreach)
		if( userByName.isPresent()) { //evaluo si ese dato que esta en esa variable existe en mi BD
			throw new IllegalStateException("El usuario con el nombre que escribiste ya existe");
		}
		userRepository.save(user); 
	}

	
	
	//Metodo UPDATE para actualizar contrasenias de usuarios
		public void updateUser(Long userId, String currentPassword, String newPassword) {
			//primero evaluo si mi usuario existe
			if(!userRepository.existsById(userId)) {
				//si no existe, arroja una excepcion
				throw new IllegalStateException("El usuario no existe");
			}
				//cuando el existsById arroja un true (que si existe en la BD), saco el valor y lo pongo en una variable temporal llamada user
				User user = userRepository.getById(userId); //esta es la variable
				//despues que las dos contrasenias no sean nulas
				if(newPassword == null || currentPassword == null) {
					//si son nulas, mando mi excepcion
					throw new IllegalStateException("Constrasenias nulas");
				}
				//evaluo que las contrasenias no sean iguales (que la nueva no sea igual a la anterior)
				if (currentPassword.equals(user.getPassword())) {
					//si las constrasenias son diferentes
					if (!newPassword.equals(user.getPassword())) {
						//seteo o actualizo con el setter la nueva contrasenia
						user.setPassword(newPassword);
						//guardo al usuario en su BD con la nueva contrasenia
						userRepository.save(user);
					}else {
						throw new IllegalStateException("La nueva contrasenia es igual a la actual");
					}
				}else {
					throw new IllegalStateException("Contrasea actual incorrecta");
			}
		}

}
