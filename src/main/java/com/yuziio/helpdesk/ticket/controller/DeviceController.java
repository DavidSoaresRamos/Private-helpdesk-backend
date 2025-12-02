package com.yuziio.helpdesk.ticket.controller;
import com.yuziio.helpdesk.ticket.model.Device;
import com.yuziio.helpdesk.ticket.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")

public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    public List<Device> getDevices() {
        return (List<Device>) deviceRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createDevice(@RequestBody Device device) {
        try {
            deviceRepository.save(device);

            System.out.println("Dispositivo criado com sucesso" + device);
            return ResponseEntity.ok("Resposta recebida com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar dispositivo " + e.getMessage());

        }
    }
}
