package com.store.car.message;

import com.store.car.dto.CarPostDTO;
import com.store.car.services.CarPostService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPost) {

        LOG.info("CAR STORE - Received Car Post information: {}");
        carPostService.newPostDetails(carPost);

    }

}

