package com.vince;

public enum Color implements Info {
    RED(10) {
        @Override
        public String getColor2(){
            return "red";
        }
    }, GREEN(20) {
        @Override
        public String getColor2(){
            return "green";
        }
    }, BLUE {
        public String getColor2(){
            return "blue";
        }
    };

    private Color(){
        System.out.println("无参构造器");
    };
    private int color;
    private Color(int color) {
        this.color = color;
        System.out.println("有参构造器");
    }

    @Override
    public int getColor() {
        return color;
    }

    public abstract String getColor2();
}
