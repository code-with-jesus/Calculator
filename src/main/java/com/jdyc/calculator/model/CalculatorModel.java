package com.jdyc.calculator.model;

import com.jdyc.calculator.gui.CalculatorView;
import com.jdyc.calculator.model.operator.Operator;

public interface CalculatorModel {

	void clear();

	String getDisplay();

	void setDisplay(String display);

	double getBuffer();

	void setBuffer(double buffer);

	boolean isInitDisplay();

	void setInitDisplay(boolean initDisplay);

	Operator getLastOperator();

	void setLastOperator(Operator lastOperator);

	void performLastOperation();
	
	void notifyObservers();

	void registerView(CalculatorView view);
}
