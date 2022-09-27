package com.vince.decorator;

public class EggDecorator extends Decorator {

	public EggDecorator(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return super.cost() + 1.5f;
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description() + " + 鸡蛋";
	}

}
