package com.vince.decorator;

public class SugarDecorator extends Decorator {

	public SugarDecorator(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return super.cost() + 1.0f;
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description() + " + 糖";
	}

}
