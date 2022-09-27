package com.vince.decorator;

/**
 * 装饰者的基类
 * @company
 * @author autuo
 * @description
 */
public abstract class Decorator implements Drink {
	private Drink drink;//要装饰的对象
	
	public Decorator(Drink drink) {
		this.drink = drink;
	}
	
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return drink.cost();
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return drink.description();
	}

}
