package com.waynebui.springkafkaconsumer.jpa;

import com.waynebui.springkafkaconsumer.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent,Integer> {
}
