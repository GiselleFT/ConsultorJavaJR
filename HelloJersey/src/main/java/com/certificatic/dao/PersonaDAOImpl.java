package com.certificatic.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.certificatic.model.Alumno;

public class PersonaDAOImpl implements PersonaDAO{

	private static Map<Integer, Alumno> alumnos = new HashMap<>();
	
	static {
		Alumno giselle = new Alumno(6, "Giselle", "Flores", "ISC");
		alumnos.put(1, giselle);
	}
	
	
	@Override
	public List<Alumno> getAlumnos() {
		//Para convertir el mapa a un arraylist
		return new ArrayList<Alumno>(alumnos.values());
	}


	@Override
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size()+1, alumno);
	}


	@Override
	public void deleteAlumno(int idAlumno) {
		alumnos.remove(idAlumno);
		
	}



}
