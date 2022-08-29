package com.programmercave.cinema.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int totalRows;
	private int totalColumns;
	private List<Seat> availableSeats;
	
	
	public Room(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }
	
	public static Room getAllSeats(int rows, int columns) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
        return new Room(rows, columns, seats);
    }


    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailable_seats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
