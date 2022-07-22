package com.example.com.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.citas.repositorio.ClienteRepositorio;
import com.example.com.dto.ClienteRequestDTO;
import com.example.com.dto.ClienteResponseDTo;
import com.example.com.modelo.Cliente;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepositorio repository;
	@Override
	public void guardarCliente(ClienteRequestDTO cliente) {
		Cliente c= new Cliente();
		c.setNombre(cliente.getNombreDTO());
		c.setCelular(cliente.getCelularDTO());
		repository.save(c);
	}

	@Override
	public void editarCliente(ClienteRequestDTO cliente) {
		Cliente c= new Cliente();
		c.setNombre(cliente.getNombreDTO());
		c.setCelular(cliente.getCelularDTO());
		repository.saveAndFlush(c);

	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ClienteResponseDTo> listarCliente() {
		List<ClienteResponseDTo> lista = new ArrayList<ClienteResponseDTo>();
		ClienteResponseDTo c = null; 
		for (Cliente cliente :repository.findAll()) {
			c = new ClienteResponseDTo();
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setNombreDTO(cliente.getNombre());
			c.setCelularDTO(cliente.getCelular());

			lista.add(c);
			
		}
		return lista;
	}

	@Override
	public ClienteResponseDTo obtenerClienteId(Integer id) {
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteResponseDTo c = new ClienteResponseDTo();
	
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setNombreDTO(cliente.getNombre());
		c.setCelularDTO(cliente.getCelular());
		return c;
	}

}
