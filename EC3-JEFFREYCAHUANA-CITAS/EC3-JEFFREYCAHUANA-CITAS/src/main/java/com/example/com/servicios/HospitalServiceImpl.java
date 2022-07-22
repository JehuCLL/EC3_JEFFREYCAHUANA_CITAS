package com.example.com.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.citas.repositorio.HospitalRepositorio;
import com.example.com.dto.HospitalRequestDTO;
import com.example.com.dto.HospitalResponseDTO;
import com.example.com.modelo.Hospital;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepositorio repository;
	@Override
	public void guardarHospital(HospitalRequestDTO hospital) {
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		repository.save(h);

	}

	@Override
	public void editarHospital(HospitalRequestDTO hospital) {
		// TODO Auto-generated method stub
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {
		List<HospitalResponseDTO> lista = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO h = null; 
		for (Hospital hospital :repository.findAll()) {
			h = new HospitalResponseDTO();
			h.setIdHospitalDTO(hospital.getIdHospital());
			h.setNombreDTO(hospital.getNombre());
			h.setDescripcionDTO(hospital.getDescripcion());
			h.setDistritoDTO(hospital.getDistrito());

			lista.add(h);
			
		}
		return lista;
	}

	@Override
	public HospitalResponseDTO obtenerHospitalId(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDTO h = new HospitalResponseDTO();
	
		h.setIdHospitalDTO(hospital.getIdHospital());
		h.setNombreDTO(hospital.getNombre());
		h.setDescripcionDTO(hospital.getDescripcion());
		h.setDistritoDTO(hospital.getDistrito());
		return h;
	}

}
