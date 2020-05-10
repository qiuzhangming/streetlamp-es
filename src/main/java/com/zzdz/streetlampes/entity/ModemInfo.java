package com.zzdz.streetlampes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(indexName = "modeminfo")
//@Document(indexName = "street_lamp",type = "modeminfo")
public class ModemInfo implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;
    private String modemId;    //Modem模块的ID号
    private long connectTime;  //Modem模块最后一次建立TCP连接的时间
    private long refreshTime;  //Modem模块最后一次发数据的时间
    private boolean online;    //Modem在线状态
    private String projectCode;
    private String modemType;
}
