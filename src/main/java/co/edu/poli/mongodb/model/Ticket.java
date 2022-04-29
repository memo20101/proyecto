package co.edu.poli.mongodb.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Tickets")
public class Ticket {
	
	//@Id
	private String fecha;
	private Integer id;
	private String tipDoc;	
	private Integer numDoc;
	private String nombre;
	private String descTick;
	
	public Ticket(String fecha, Integer id, String tipDoc, Integer numDoc, String nombre, String descTick) {
		super();
		this.fecha = fecha;
		this.id = id;
		this.tipDoc = tipDoc;
		this.numDoc = numDoc;
		this.nombre = nombre;
		this.descTick = descTick;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipDoc() {
		return tipDoc;
	}

	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}

	public Integer getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(Integer numDoc) {
		this.numDoc = numDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescTick() {
		return descTick;
	}

	public void setDescTick(String descTick) {
		this.descTick = descTick;
	}
	

	

	
}