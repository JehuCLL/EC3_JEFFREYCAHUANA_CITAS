package com.example.com.servicios;

import java.util.List;

import com.example.com.dto.HospitalRequestDTO;
import com.example.com.dto.HospitalResponseDTO;

public interface HospitalService {

	public void guardarHospital(HospitalRequestDTO hospital);
	public void editarHospital(HospitalRequestDTO hospital);
	public void eliminarHospital(Integer id);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO obtenerHospitalId(Integer id);
	
}
