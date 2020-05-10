package com.zzdz.streetlampes.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LampControllerAlarmSettings implements Serializable {

    private boolean overCurrentAlarmSwitch;    //过流报警开关    0关 1开 默认:开
    private boolean underCurrentAlarmSwitch;   //欠流报警开关    0关 1开 默认:开
    private boolean overVoltageAlarmSwitch;    //过压报警开关    0关 1开 默认:开
    private boolean underVoltageAlarmSwitch;   //欠压报警开关    0关 1开 默认:开
    private boolean moduleDamageAlarmSwitch;   //模组损坏报警开关 0关 1开 默认:关
    private boolean controlDamageAlarmSwitch;  //控制损坏报警开关 0关 1开 默认:关
    private boolean detectDamageAlarmSwitch;   //检测损坏报警开关 0关 1开 默认:关
    private boolean electricLeakageAlarmSwitch;//漏电报警开关    0关 1开 默认:关
    private boolean lampPoleAngleOfInclinationSwitch;//灯杆倾斜度报警开关 0关  1开

    private double overCurrentThreshold;//电流过大阀值 0.001A  范围:1~10000 默认:5000
    private int overCurrentDuration;//电流过大持续时间 S        范围:1~1000  默认:30
    private double underCurrentThreshold;//电流过小阀值 0.001A 范围:1~10000 默认:50
    private int underCurrentDuration;//电流过小持续时间 S       范围:1~1000  默认:30
    private double overVoltageThreshold;//电压过高阀值 0.1V    范围:1~10000 默认:2500
    private int overVoltageDuration;//电压过高持续时间 S        范围:1~1000  默认:30
    private double underVoltageThreshold;//电压过低阀值 0.1V   范围:1~10000 默认:1800
    private int underVoltageDuration;//电压过低持续时间 S       范围:1~1000  默认:30
    private double loadPowerRating;//负载额定功率阀值 0.1W      范围:1~10000 默认:400
    private int loadPowerRatingDuration;//负载额定功率持续时间 S 范围:1~1000  默认:30
    private int moduleDamageDuration;//模组损坏持续时间 S       范围:1~1000  默认:30
    private int controlDamageDuration;//控制损坏持续时间 S      范围:1~1000  默认:30
    private int detectDamageDuration;//检测损坏持续时间 S       范围:1~1000  默认:30
    private int electricLeakageDuration;//漏电持续时间 S       范围:1~1000  默认:30

    private double lampPoleAngleOfInclinationThreshold;//灯杆倾斜度报警阀值
    private int lampPoleAngleOfInclinationDuration;//灯杆倾斜度报警持续时间

    private long alarmSettingsTimeStamp;//平台时间戳
    private long timeStamp;//协议时间戳
}
