package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampRtuSettings;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampRtuSettingsRepository extends ElasticsearchRepository<LampRtuSettings,String> {
}
