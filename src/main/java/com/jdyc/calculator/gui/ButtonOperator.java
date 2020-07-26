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
package com.jdyc.calculator.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jdyc.calculator.model.operator.Operator;
import com.jdyc.calculator.controller.CalculatorController;

@SuppressWarnings("serial")
public class ButtonOperator extends JRoundButton {

	public ButtonOperator(final CalculatorController ctr, final Operator op) {

		super(op.label);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				ctr.processOperator(op);
			}
		});
		setColor2(Color.green);
		setForeground(new Color(50, 50, 50));
	}
}
