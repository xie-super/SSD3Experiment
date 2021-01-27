package com.company.controller;

import com.company.view.NewJDialog;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrameController extends javax.swing.JFrame {


    public MainFrameController(){
        initComponents();
        initListeners();
        Timer timer=new Timer();
        //定时器执行任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int second=Integer.parseInt(secondSpinner.getValue().toString());
                second++;
                secondSpinner.setValue(second);
                repaint();
            }
        },0,1000);
    }

    public void showMainWindows(){
        windowFrame.setVisible(true);
    }
    public void initComponents(){
        windowFrame= new NewJDialog();
        hourSpinner=windowFrame.getjSpinner1();
        minuteSpinner=windowFrame.getjSpinner2();
        secondSpinner=windowFrame.getjSpinner3();
        okButton=windowFrame.getjButton1();
        cancelButton=windowFrame.getjButton2();
        applyButton=windowFrame.getjButton3();

    }
    public void initListeners(){

        //分钟状态改变事件
        hourSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //获取到当前时
                int hour = Integer.parseInt(hourSpinner.getValue().toString());

                //时的变化退位
                if (hour== -1) {
                    hourSpinner.setValue(23);
                }

                //时的变化进位
                if (hour == 24) {
                    hourSpinner.setValue(0);
                }
            }
        });

        //分钟状态改变事件
        minuteSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //获取到当前时分
                int hour = Integer.parseInt(hourSpinner.getValue().toString());
                int minute = Integer.parseInt(minuteSpinner.getValue().toString());

                //时分的变化退位
                if (minute== -1) {

                        if (hour == 0) {
                            hourSpinner.setValue(23);
                        } else {
                            hourSpinner.setValue(hour - 1);
                        }
                        minuteSpinner.setValue(59);

                }

                //时分的变化进位
                if (minute == 60) {

                        if (hour == 23) {
                            hourSpinner.setValue(0);
                        } else {
                            hourSpinner.setValue(hour + 1);
                        }
                        minuteSpinner.setValue(0);


                }
            }
        });

        //秒钟状态改变事件
        secondSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //获取到当前时分秒
                int hour = Integer.parseInt(hourSpinner.getValue().toString());
                int minute = Integer.parseInt(minuteSpinner.getValue().toString());
                int second = Integer.parseInt(secondSpinner.getValue().toString());


                //秒时分的变化退位
                if (second == -1) {
                    if (minute == 0) {
                        if (hour == 0) {
                            hourSpinner.setValue(23);
                        } else {
                            hourSpinner.setValue(hour - 1);
                        }
                        minuteSpinner.setValue(59);
                    } else {
                        minuteSpinner.setValue(minute - 1);
                    }
                    secondSpinner.setValue(59);
                }

                //秒时分的变化进位
                if (second == 60) {
                    if (minute == 59) {
                        if (hour == 23) {
                            hourSpinner.setValue(0);
                        } else {
                            hourSpinner.setValue(hour + 1);
                        }
                        minuteSpinner.setValue(0);
                    } else {
                        minuteSpinner.setValue(minute + 1);
                    }
                    secondSpinner.setValue(0);

                }
            }
        });




    }



    NewJDialog windowFrame;
    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JSpinner hourSpinner;
    private javax.swing.JSpinner minuteSpinner;
    private javax.swing.JSpinner secondSpinner;

}
