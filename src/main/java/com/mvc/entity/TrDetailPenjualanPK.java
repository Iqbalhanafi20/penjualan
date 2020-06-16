package com.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class TrDetailPenjualanPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="KODE_DETAIL")
	private String kodeDetail;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeDetail == null) ? 0 : kodeDetail.hashCode());
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
		TrDetailPenjualanPK other = (TrDetailPenjualanPK) obj;
		if (kodeDetail == null) {
			if (other.kodeDetail != null)
				return false;
		} else if (!kodeDetail.equals(other.kodeDetail))
			return false;
		return true;
	}

	public String getKodeDetail() {
		return kodeDetail;
	}

	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	

}
