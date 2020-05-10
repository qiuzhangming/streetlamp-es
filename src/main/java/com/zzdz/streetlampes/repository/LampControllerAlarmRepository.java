package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampControllerAlarm;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampControllerAlarmRepository extends ElasticsearchRepository<LampControllerAlarm,String> {
}
