package com.jdyc.calculator.model;

import com.jdyc.calculator.gui.CalculatorView;

import java.util.ArrayList;
import java.util.List;

import com.jdyc.calculator.model.operator.Operator;

public class CalculatorModelImpl implements CalculatorModel {

	// --------------------------------------------------
	// Properties
	// --------------------------------------------------

	/**
	 * Used to show the current value/result.
	 */
	private String display;

	/**
	 * Store the previous value of the display.
	 */
	private double buffer;

	/**
	 * Indicate if the display should be cleaned or not.
	 */
	private boolean initDisplay;

	/**
	 * The last operator button typed.
	 */
	private Operator lastOperator;

	/**
	 * Observer views;
	 */
	private List<CalculatorView> views = new ArrayList<CalculatorView>();

	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------

	public CalculatorModelImpl() {
		clear();
	}

	// --------------------------------------------------
	// Methods
	// --------------------------------------------------

	public void clear() {
		this.display = "0";
		this.buffer = 0;
		this.initDisplay = true;
	}

	public String getDisplay() {
		display = (display == null) ? "0" : display;
		if (display.endsWith(".0")) {
			display = display.substring(0, display.length() - 2);
		}
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
		notifyObservers();
	}

	public double getBuffer() {
		return buffer;
	}

	public void setBuffer(double buffer) {
		this.buffer = buffer;
	}

	public boolean isInitDisplay() {
		return initDisplay;
	}

	public void setInitDisplay(boolean initDisplay) {
		this.initDisplay = initDisplay;
	}

	public Operator getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(Operator lastOperator) {
		this.lastOperator = lastOperator;
	}

	public void performLastOperation() {
		if (lastOperator == null)
			return;

		lastOperator.execute(this);
	}

	public void notifyObservers() {
		for (CalculatorView view : views) {
			view.update(this);
		}
	}

	public void registerView(CalculatorView view) {
		views.add(view);
	}
}
