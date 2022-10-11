package com.jaimerojas.springboot.backend.apirest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.jaimerojas.springboot.backend.apirest.models.dao.IClienteDao;
import com.jaimerojas.springboot.backend.apirest.models.entity.Cliente;
//import com.jaimerojas.springboot.backend.apirest.service.iClienteService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClienteTest {

	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Test
	@Rollback(false)
	public void testGuardarCliente() {
		
		Cliente cliente = new Cliente("Fabian", "Troncoso", "fabi@gamil.com");
		Cliente clienteGuardado = clienteDao.save(cliente);
		
		 assertNotNull(clienteGuardado);
	}
	
	@Test
	public void testListarClientes() {
		
		List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
		
		for(Cliente cliente : clientes) {
			
			System.out.println(cliente);
		}
		
		assertThat(clientes).size().isGreaterThan(0);
		
	}
	
	@Test
	@Rollback(false)
	public void TestEliminarProducto() {
		
		Long id = 18L;
		
		boolean esExistenteAntesDeEliminar = clienteDao.findById(id).isPresent();
		
		clienteDao.deleteById(id);

		boolean esExistenteDespuesDeEliminar = clienteDao.findById(id).isPresent(); 
		
		assertTrue(esExistenteAntesDeEliminar);
		assertFalse(esExistenteDespuesDeEliminar);
		
	}
	
}

//Aún me falta el modificar cliente...