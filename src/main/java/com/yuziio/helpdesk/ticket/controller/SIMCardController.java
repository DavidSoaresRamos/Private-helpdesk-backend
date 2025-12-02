package com.yuziio.helpdesk.ticket.controller;
import com.yuziio.helpdesk.ticket.model.SIMCard;
import com.yuziio.helpdesk.ticket.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SIMCard")
public class SIMCardController {

    @Autowired
    private CardRepository cardRepository;

}
