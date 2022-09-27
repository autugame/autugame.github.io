package com.vince.decorator;

public class Text {

	public static void main(String[] args) {
		Drink drink = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(drink);
		EggDecorator egg = new EggDecorator(sugar);
		BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);
		
		System.out.println("你点的豆浆是" + blackBean.description());
		System.out.println("一共花了" + blackBean.cost() + "元");
	}

}
