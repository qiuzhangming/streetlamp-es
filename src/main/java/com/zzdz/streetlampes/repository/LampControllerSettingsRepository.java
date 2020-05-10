package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampControllerSettings;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampControllerSettingsRepository extends ElasticsearchRepository<LampControllerSettings,String> {
}
