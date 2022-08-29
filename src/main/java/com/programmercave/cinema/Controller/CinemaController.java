package com.programmercave.cinema.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.programmercave.cinema.Model.Room;
import com.programmercave.cinema.Model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.programmercave.cinema.Model.Room.getAllSeats;

@RestController
public class CinemaController {
	private final Room room;

    public CinemaController() {
        this.room = getAllSeats(9 ,9);
    }

    @GetMapping("/seats")
    public Room getSeats() {
        return room;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody Seat seat) {
        if (seat.getColumn() > room.getTotalColumns()
            || seat.getRow() > room.getTotalRows()
            || seat.getRow() < 1
            || seat.getColumn() < 1) {

            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }

        for (int i = 0; i < room.getAvailableSeats().size(); ++i) {
            Seat s = room.getAvailableSeats().get(i);
            if (s.equals(seat)) {
                room.getAvailableSeats().remove(i);
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }
}
