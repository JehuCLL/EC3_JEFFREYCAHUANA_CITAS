package com.example.com.servicios;

import java.util.List;

import com.example.com.dto.ClienteRequestDTO;
import com.example.com.dto.ClienteResponseDTo;

public interface ClienteService {

	public void guardarCliente(ClienteRequestDTO cliente);
	public void editarCliente(ClienteRequestDTO cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteResponseDTo> listarCliente();
	public ClienteResponseDTo obtenerClienteId(Integer id);
	
}
