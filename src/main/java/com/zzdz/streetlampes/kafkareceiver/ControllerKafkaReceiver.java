package com.zzdz.streetlampes.kafkareceiver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzdz.streetlampes.entity.LampControllerAlarm;
import com.zzdz.streetlampes.entity.LampControllerSettings;
import com.zzdz.streetlampes.entity.LampControllerStatus;
import com.zzdz.streetlampes.repository.LampControllerAlarmRepository;
import com.zzdz.streetlampes.repository.LampControllerSettingsRepository;
import com.zzdz.streetlampes.repository.LampControllerStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ControllerKafkaReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    LampControllerStatusRepository lampControllerStatusRepository;

    @Autowired
    LampControllerAlarmRepository lampControllerAlarmRepository;

    @Autowired
    LampControllerSettingsRepository lampControllerSettingsRepository;
    /**
     * 接收controller状态信息
     */
    @KafkaListener(topics = {"LampControllerStatus"})
    public void lampControllerStatus(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                List<LampControllerStatus> lampControllerStatusList = objectMapper.readValue((String) message, new TypeReference<List<LampControllerStatus>>() {
                });
                if (lampControllerStatusList.isEmpty()) return;

                for (LampControllerStatus lampControllerStatus : lampControllerStatusList) {
                    //if (lampControllerStatus.getUuid() == null || lampControllerStatus.getUuid().isEmpty()) continue;

                    lampControllerStatus.setId(UUID.randomUUID().toString());
                    lampControllerStatusRepository.save(lampControllerStatus);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收controller报警信息
     */
    @KafkaListener(topics = {"LampControllerAlarm"})
    public void lampControllerAlarm(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                List<LampControllerAlarm> lampControllerAlarmList = objectMapper.readValue((String) message, new TypeReference<List<LampControllerAlarm>>() {
                });
                if (lampControllerAlarmList.isEmpty()) return;

                for (LampControllerAlarm lampControllerAlarm : lampControllerAlarmList) {
                    //if (lampControllerAlarm.getUuid() == null || lampControllerAlarm.getUuid().isEmpty()) continue;

                    lampControllerAlarm.setId(UUID.randomUUID().toString());
                    lampControllerAlarmRepository.save(lampControllerAlarm);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收controller设置信息
     */
    @KafkaListener(topics = {"LampControllerSettings"})
    public void lampControllerSettings(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                List<LampControllerSettings> lampControllerSettingsList = objectMapper.readValue((String) message, new TypeReference<List<LampControllerSettings>>() {
                });
                if (lampControllerSettingsList.isEmpty()) return;

                for (LampControllerSettings lampControllerSettings : lampControllerSettingsList) {
                    //if (lampControllerSettings.getUuid() == null || lampControllerSettings.getUuid().isEmpty()) continue;

                    lampControllerSettings.setId(UUID.randomUUID().toString());
                    lampControllerSettingsRepository.save(lampControllerSettings);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
