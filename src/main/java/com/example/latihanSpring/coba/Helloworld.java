package com.example.latihanSpring.coba;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
    
    // url: Localhost:9090/halo
    @GetMapping("/halo")
    public String halo(@RequestParam(value = "name", defaultValue = "Dunia")String name){
        return String.format("Halo %s!", name);
    }

    // WHAT IS: LOCALHOST:9090/HALO?NAME=RUDI??
}
