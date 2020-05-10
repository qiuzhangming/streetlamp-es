package com.zzdz.streetlampes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Document(indexName = "lamp_rtu_alarm")
//@Document(indexName = "street_lamp",type = "lamp_rtu_alarm")
public class LampRtuAlarm implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String rtuId;
    private long timeStamp;//时间戳
    private boolean powerCutAlarm;//停电报警
    private boolean losesPhaseA;//A缺相
    private boolean losesPhaseB;//B缺相
    private boolean losesPhaseC;//C缺相
    private boolean openDoorAlarm;//门开报警
    private boolean waterAlarm;//水浸报警
    private boolean cableBrokenAlarm;//断线报警
    private boolean electricLeakageAlarm;//漏电报警
    private boolean currentFluctuationAlarm;//电流波动报警
    private boolean[] openException;//异常开灯 对应1-13号交流接触器
    private boolean[] closeException;//异常关灯 对应1-13号交流接触器
    private boolean[] circuitBroken;//断路报警 对应1-13支路
    private long dataPersistenceTimestamp;//记录最后一次数据存盘的时间
    /**
     * 需要查询数据库
     */
    private String secondGroupName;//二级分组名字
    private String name;
    private String boxNumber;//箱体编号
    private String longitude;//经度
    private String latitude;//纬度
}
