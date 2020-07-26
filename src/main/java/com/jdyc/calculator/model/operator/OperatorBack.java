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
package com.jdyc.calculator.model.operator;

import com.jdyc.calculator.main.Constants;
import com.jdyc.calculator.model.CalculatorModel;

public class OperatorBack extends UnaryOperator {

	public OperatorBack() {
		super(Constants.BACK);
	}

	@Override
	public void execute(CalculatorModel model) {
		int length = model.getDisplay().length();
		String display = (length > 1) ? model.getDisplay().substring(0, length - 1) : "0";
		model.setDisplay(display);
		model.setInitDisplay(length <= 1);
	}

}
