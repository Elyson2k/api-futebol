package com.racha.project.entities.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;

public class PartidaPOST {
	
	private String local;
	@Column(unique = true)
	private Date horas;
	
	public PartidaPOST() {}

	public String getLocal() {
		return local;
	}

	public Date getHoras() {
		return horas;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setHoras(Date horas) {
		this.horas = horas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horas, local);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidaPOST other = (PartidaPOST) obj;
		return Objects.equals(horas, other.horas) && Objects.equals(local, other.local);
	};
	
	
}
