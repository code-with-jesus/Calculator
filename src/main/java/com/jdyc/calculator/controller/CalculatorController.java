/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jdyc.calculator.controller;

import com.jdyc.calculator.gui.CalculatorView;
import com.jdyc.calculator.gui.CalculatorViewImpl;
import com.jdyc.calculator.main.Constants;
import com.jdyc.calculator.model.CalculatorModel;
import com.jdyc.calculator.model.CalculatorModelImpl;
import com.jdyc.calculator.model.operator.BinaryOperator;
import com.jdyc.calculator.model.operator.Operator;
import com.jdyc.calculator.model.operator.UnaryOperator;

public class CalculatorController {

	// --------------------------------------------------
	// Properties
	// --------------------------------------------------

	/**
	 * Singleton instance of this controller.
	 */
	private static CalculatorController instance;

	/**
	 * Model.
	 */
	private CalculatorModel model;

	/**
	 * View.
	 */
	private CalculatorView view;

	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------

	private CalculatorController() {
		this.model = new CalculatorModelImpl();
		this.view = new CalculatorViewImpl(this, model);
	}

	// --------------------------------------------------
	// Methods
	// --------------------------------------------------

	public static CalculatorController getInstance() {
		if (instance == null) {
			instance = new CalculatorController();
		}
		return instance;
	}

	public void init() {
		view.show();
	}

	public void processDigit(String str) {
		if (model.isInitDisplay()) {
			if (str.equals(Constants.POINT)) {
				str = Constants.ZERO + str;
			}
			model.setDisplay(str);
			model.setInitDisplay(false);

		} else {

			if (model.getDisplay().equals(Constants.ZERO)) {
				if (!str.equals(Constants.ZERO)) {
					model.setDisplay(model.getDisplay() + str);
				}

			} else if (model.getDisplay().indexOf(Constants.POINT) == -1) {
				model.setDisplay(model.getDisplay() + str);

			} else if (!str.equals(Constants.POINT)) {
				model.setDisplay(model.getDisplay() + str);
			}
		}
	}

	public void processOperator(final Operator op) {
		if (op instanceof BinaryOperator) {
			if (!model.isInitDisplay()) {
				model.performLastOperation();
			}
			model.setBuffer(Double.parseDouble(model.getDisplay()));
			model.setLastOperator(op);
			model.setInitDisplay(true);

		} else if (op instanceof UnaryOperator) {
			op.execute(model);
		}
	}
}
