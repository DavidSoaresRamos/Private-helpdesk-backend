package com.yuziio.helpdesk.ticket.repository;

import com.yuziio.helpdesk.ticket.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {


}
