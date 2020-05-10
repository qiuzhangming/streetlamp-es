package com.zzdz.streetlampes.kafkareceiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzdz.streetlampes.entity.LampGatewaySettings;
import com.zzdz.streetlampes.repository.LampGatewaySettingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class GatewayKafkaReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    LampGatewaySettingsRepository lampGatewaySettingsRepository;

    @KafkaListener(topics = {"LampGatewaySettings"})
    public void lampGatewaySettings(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                LampGatewaySettings lampGatewaySettings = objectMapper.readValue((String) message, LampGatewaySettings.class);
                if (lampGatewaySettings == null) return;

                //if (lampGatewaySettings.getUuid() == null || lampGatewaySettings.getUuid().isEmpty()) return;

                lampGatewaySettings.setId(UUID.randomUUID().toString());
                lampGatewaySettingsRepository.save(lampGatewaySettings);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
