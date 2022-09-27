package com.vince.gui;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame implements ActionListener {
    //初始窗体基本属性
    public MyFrame() {
        this.setSize(600, 400);
        this.setTitle("第一个gui窗体");
        Button button = new Button("点我一下有惊喜");
        button.addActionListener(this);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //把按钮添加到窗体上
        this.add(button);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    //单击事件处理
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("惊喜来了");
    }
}
