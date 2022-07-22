package com.example.com.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.com.dto.ClienteRequestDTO;
import com.example.com.dto.ClienteResponseDTo;


@RequestMapping("/reservacita")
public class ClienteController {

	@Autowired
	private com.example.com.servicios.ClienteService servicio;
	
	@RequestMapping(path = "/cliente/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteResponseDTo>> listarClientes(){
		return new ResponseEntity<List<ClienteResponseDTo>>(servicio.listarCliente(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/cliente/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDTO cliente){
		servicio.guardarCliente(cliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);	
	}
	
	@RequestMapping(path = "/cliente/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ClienteResponseDTo> listarPorId(@PathVariable Integer id) {
		ClienteResponseDTo c = servicio.obtenerClienteId(id);
		if(c != null) {
			return new ResponseEntity<ClienteResponseDTo>(c, HttpStatus.OK);
		}
		return new ResponseEntity<ClienteResponseDTo>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/cliente/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteRequestDTO cliente){
		ClienteResponseDTo c = servicio.obtenerClienteId(cliente.getIdClienteDTO());
		if(c != null) {
			servicio.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/cliente/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ClienteResponseDTo c = servicio.obtenerClienteId(id);
		if(c != null) {
			servicio.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
