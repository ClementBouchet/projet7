package org.ocproject.service;

import java.util.List;

import org.ocproject.beans.Reservation;

public interface ReservationManager {
	public List<Reservation> selectByIdLivre(int idLivre);
	public List<Reservation> selectByIdUser(int idUser);
	public List<Reservation> selectAll();
}
