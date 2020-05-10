package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampGatewaySettings;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampGatewaySettingsRepository extends ElasticsearchRepository<LampGatewaySettings,String> {
}
