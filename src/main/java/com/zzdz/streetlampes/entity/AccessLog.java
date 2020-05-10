package com.zzdz.streetlampes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@Document(indexName = "access_log")
public class AccessLog {
    @JsonSetter("id")
    private long uuid;

    @Id
    @JsonIgnore
    private String id;

    private String uip;//用户ip地址

    private String method;
    private String requestUrl;
    private String serverName;
    private String requestURI;
    private String queryString;//get请求参数
    private String requestPayload;//post请求json

    private long requestTimestamp;
}
