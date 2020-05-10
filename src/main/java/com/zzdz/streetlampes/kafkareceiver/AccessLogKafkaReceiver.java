package com.zzdz.streetlampes.kafkareceiver;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzdz.streetlampes.entity.AccessLog;
import com.zzdz.streetlampes.repository.AccessLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class AccessLogKafkaReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccessLogRepository accessLogRepository;

    @KafkaListener(topics = {"AccessLog"})
    public void test(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            try {
                AccessLog accessLog = objectMapper.readValue((String) message, AccessLog.class);
                if (accessLog == null) return;

                accessLog.setId(UUID.randomUUID().toString());
                accessLogRepository.save(accessLog);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
