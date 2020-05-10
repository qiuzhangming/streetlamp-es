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
@Document(indexName = "lamp_controller_status")
//@Document(indexName = "street_lamp",type = "lamp_controller_status")
public class LampControllerStatus implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String controllerId;
    private boolean ioStatus;//输出状态
    private double voltage;//电压
    private double brightness;//亮度
//    private double current;//电流
//    private double pa;//有功功率
//    private double pra;//功率因素
//    private double ea;//电能
    private short alarmFlag;
    private long statusTimestamp;
    private long dataPersistenceTimestamp;//记录最后一次数据存盘的时间
    /**
     * 需要查询数据库
     */
    private String lampGatewayId;
    private String gatewayName;
    private String lamppostId;//灯杆id，方便前端遍历
    private String lamppostName;
    private String lamppostNumber;
    private String name;
    private String longitude;//经度
    private String latitude;//纬度
    //NB增加属性
    private double currentIn;//输入有效值电流
    private double currentOut;//输出有效值电流 0.001
    private double activePowerIn;//输入有功功率 0.1W
    private double activePowerOut;//输出有功功率 0.1W
    private double reactivePower;//无功功率 0.1Var
    private double apparentPower;//视在功率 0.1VA
    private double powerFactor;//功率因数 0.001
    private int risi;//NB模块的信号强度值 1~32
    private double energyPowerToday;//本日有功电能0.001千瓦时
    private double energyPowerTotal;//总有功电能

    //增加
    private boolean inputStatus;//输入状态 0正常  1开启
    private double cavityTemperature;//腔体温度 0.1
    private double lampPoleAngleOfInclination;//灯杆倾斜角度 0.1度
    private double energyPowerCurrentValue;//单灯电能当前读值 0.001
    private double systemRunningTimeToday;//系统运行时间（今天）单位分钟
    private double systemRunningTimeTotal;//系统总运行时间 分钟
    private String pci;//pci
    private String cellid;//平台需要的cellID
    private String rsrp;//平台需要的rsrp
    private String snr;//平台需要的snr
}
