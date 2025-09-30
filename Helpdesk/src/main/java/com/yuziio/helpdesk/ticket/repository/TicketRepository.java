package com.yuziio.helpdesk.ticket.repository;

import com.yuziio.helpdesk.ticket.model.Ticket; /* Importa o ticket que vai ser salvo no banco */
import org.springframework.data.mongodb.repository.MongoRepository; /* Importa uma interface MongoDB do proprio Spring */
import org.springframework.stereotype.Repository;

@Repository /* Marca a classe como uma classe que acessa o banco de dados */

/* Permite a classe herdar os metodos ja prontos do MongoRepository */
public interface TicketRepository extends MongoRepository<Ticket, String> {
}