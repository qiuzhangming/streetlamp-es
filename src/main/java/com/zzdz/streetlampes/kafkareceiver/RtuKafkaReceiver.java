package com.zzdz.streetlampes.kafkareceiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzdz.streetlampes.entity.LampRtuAlarm;
import com.zzdz.streetlampes.entity.LampRtuSettings;
import com.zzdz.streetlampes.entity.LampRtuStatus;
import com.zzdz.streetlampes.repository.LampRtuAlarmRepository;
import com.zzdz.streetlampes.repository.LampRtuSettingsRepository;
import com.zzdz.streetlampes.repository.LampRtuStatusRepository;
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
public class RtuKafkaReceiver {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    LampRtuStatusRepository lampRtuStatusRepository;

    @Autowired
    LampRtuAlarmRepository lampRtuAlarmRepository;

    @Autowired
    LampRtuSettingsRepository lampRtuSettingsRepository;
    /**
     * 接收rtu状态信息
     */
    @KafkaListener(topics = {"LampRtuStatus"})
    public void lampRtuStatus(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                LampRtuStatus lampRtuStatus = objectMapper.readValue((String) message, LampRtuStatus.class);
                if (lampRtuStatus == null) return;

                //if (lampRtuStatus.getUuid() == null || lampRtuStatus.getUuid().isEmpty()) return;

                lampRtuStatus.setId(UUID.randomUUID().toString());
                lampRtuStatusRepository.save(lampRtuStatus);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收rtu报警信息
     */
    @KafkaListener(topics = {"LampRtuAlarm"})
    public void lampRtuAlarm(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                LampRtuAlarm lampRtuAlarm = objectMapper.readValue((String) message, LampRtuAlarm.class);
                if (lampRtuAlarm == null) return;

                //if (lampRtuAlarm.getUuid() == null || lampRtuAlarm.getUuid().isEmpty()) return;

                lampRtuAlarm.setId(UUID.randomUUID().toString());
                lampRtuAlarmRepository.save(lampRtuAlarm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收rtu设置信息
     */
    @KafkaListener(topics = {"LampRtuSettings"})
    public void lampRtuSettings(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                LampRtuSettings lampRtuSettings = objectMapper.readValue((String) message, LampRtuSettings.class);
                if (lampRtuSettings == null) return;

                //if (lampRtuSettings.getUuid() == null || lampRtuSettings.getUuid().isEmpty()) return;

                lampRtuSettings.setId(UUID.randomUUID().toString());
                lampRtuSettingsRepository.save(lampRtuSettings);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
