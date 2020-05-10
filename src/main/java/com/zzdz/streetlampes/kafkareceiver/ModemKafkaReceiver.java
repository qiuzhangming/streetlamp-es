package com.zzdz.streetlampes.kafkareceiver;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzdz.streetlampes.entity.ModemInfo;
import com.zzdz.streetlampes.repository.ModemInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Component
public class ModemKafkaReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ModemInfoRepository modemInfoRepository;

    @KafkaListener(topics = {"ModemInfo"})
    public void modemInfo(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                ModemInfo modemInfo = objectMapper.readValue((String) message, ModemInfo.class);
                if (modemInfo == null) return;

                //if (modemInfo.getUuid() == null || modemInfo.getUuid().isEmpty()) return;

                modemInfo.setId(UUID.randomUUID().toString());
                modemInfoRepository.save(modemInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
