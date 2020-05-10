package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampRtuAlarm;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampRtuAlarmRepository extends ElasticsearchRepository<LampRtuAlarm,String> {
}
