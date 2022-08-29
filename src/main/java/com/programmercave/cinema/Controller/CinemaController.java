package com.programmercave.cinema.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.programmercave.cinema.Model.Room;

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
}
