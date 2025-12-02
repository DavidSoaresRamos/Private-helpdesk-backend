package com.yuziio.helpdesk.ticket.repository;
import com.yuziio.helpdesk.ticket.model.SIMCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends MongoRepository<SIMCard, String> {


}
