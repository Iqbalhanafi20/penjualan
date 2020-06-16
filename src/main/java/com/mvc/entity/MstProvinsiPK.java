package com.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class MstProvinsiPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="KODE_PROVINSI")
	private String kodeProvinsi;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeProvinsi == null) ? 0 : kodeProvinsi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstProvinsiPK other = (MstProvinsiPK) obj;
		if (kodeProvinsi == null) {
			if (other.kodeProvinsi != null)
				return false;
		} else if (!kodeProvinsi.equals(other.kodeProvinsi))
			return false;
		return true;
	}

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	
	
}
