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
@Document(indexName = "lamp_rtu_status")
//@Document(indexName = "street_lamp",type = "lamp_rtu_status")
public class LampRtuStatus implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String rtuId;
    private long statusTimestamp;
    private double mcuTemperature;//设备温度
    private double electricityMeterValue;//电表读数
    //三相电压
    private double va;
    private double vb;
    private double vc;
    //三相电流
    private double ca;
    private double cb;
    private double cc;
    //有功功率
    private double pa;
    private double pb;
    private double pc;
    //无功功率
    private double qa;
    private double qb;
    private double qc;
    //功率因素
    private double pra;
    private double prb;
    private double prc;
    //电表电能
    private double ea;
    private double eb;
    private double ec;
    //有功电度
    private double wpa;
    private double wpb;
    private double wpc;
    //无功电度
    private double wqa;
    private double wqb;
    private double wqc;
    //漏电电流
    private double ela;
    private double elb;
    private double elc;
    //电压频率
    private double vfa;
    private double vfb;
    private double vfc;
    //三相状态
    private boolean phaseA;
    private boolean phaseB;
    private boolean phaseC;

    private double[] branchCurrent;//13个支路电流
    private boolean[] contactorStatus;//13个交流接触器状态
    private boolean[] switchStatus;//8路开关
    private long dataPersistenceTimestamp;//记录最后一次数据存盘的时间
    private String secondGroupName;//二级分组名字
    private String name;
    private String boxNumber;//箱体编号
    private String longitude;//经度
    private String latitude;//纬度
}
