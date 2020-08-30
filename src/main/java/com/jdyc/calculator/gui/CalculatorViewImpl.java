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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jdyc.calculator.controller.CalculatorController;
import com.jdyc.calculator.main.Constants;
import com.jdyc.calculator.model.CalculatorModel;
import com.jdyc.calculator.model.operator.OperatorAdd;
import com.jdyc.calculator.model.operator.OperatorBack;
import com.jdyc.calculator.model.operator.OperatorClear;
import com.jdyc.calculator.model.operator.OperatorDiv;
import com.jdyc.calculator.model.operator.OperatorEquals;
import com.jdyc.calculator.model.operator.OperatorMul;
import com.jdyc.calculator.model.operator.OperatorSign;
import com.jdyc.calculator.model.operator.OperatorSqrt;
import com.jdyc.calculator.model.operator.OperatorSub;

@SuppressWarnings("serial")
public class CalculatorViewImpl extends JFrame implements CalculatorView {

	JTextField display;

	ButtonDigit button0, button1, button2, button3, button4, button5, button6,
			button7, button8, button9, buttonPoint;

	ButtonOperator buttonEqual, buttonAdd, buttonSub, buttonMult, buttonDiv,
			buttonSqrt, buttonClear, buttonBack, buttonSign;

	CalculatorController controller;

	CalculatorModel model;

	public CalculatorViewImpl(CalculatorController controller,
			CalculatorModel model) {

		this.controller = controller;
		this.model = model;
		model.registerView(this);

		setSize(350, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	private void init() {
		JPanel displayPanel = new JPanel(new GridLayout(1, 1, 25, 25));
		JPanel buttonsPanel = new JPanel(new GridLayout(5, 4, 25, 25));
		buttonsPanel.setBackground(new Color(150, 150, 150));

		add(displayPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.CENTER);

		display = new JTextField("0");
		display.setBackground(new Color(235, 235, 250));
		display.setPreferredSize(new Dimension(320, 50));
		display.setEditable(false);
		display.setFont(new Font("Arial", 3, 29));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setOpaque(true);
		displayPanel.add(display);

		// First row

		buttonClear = new ButtonOperator(controller, new OperatorClear());
		buttonClear.setColor2(Color.red);
		buttonClear.setToolTipText("Clear.");
		buttonsPanel.add(buttonClear);

		buttonBack = new ButtonOperator(controller, new OperatorBack());
		buttonBack.setColor2(new Color(200, 150, 0));
		buttonBack.setToolTipText("Back.");
		buttonsPanel.add(buttonBack);

		buttonSign = new ButtonOperator(controller, new OperatorSign());
		buttonSign.setColor2(new Color(200, 150, 0));
		buttonSign.setToolTipText("Change sign.");
		buttonsPanel.add(buttonSign);

		buttonSqrt = new ButtonOperator(controller, new OperatorSqrt());
		buttonSqrt.setToolTipText("Sqrt.");
		buttonsPanel.add(buttonSqrt);

		// Second row

		button7 = new ButtonDigit(controller, Constants.SEVEN);
		buttonsPanel.add(button7);

		button8 = new ButtonDigit(controller, Constants.EIGHT);
		buttonsPanel.add(button8);

		button9 = new ButtonDigit(controller, Constants.NINE);
		buttonsPanel.add(button9);

		buttonDiv = new ButtonOperator(controller, new OperatorDiv());
		buttonDiv.setToolTipText("Divide.");
		buttonsPanel.add(buttonDiv);

		// Third row

		button4 = new ButtonDigit(controller, Constants.FOUR);
		buttonsPanel.add(button4);

		button5 = new ButtonDigit(controller, Constants.FIVE);
		buttonsPanel.add(button5);

		button6 = new ButtonDigit(controller, Constants.SIX);
		buttonsPanel.add(button6);

		buttonMult = new ButtonOperator(controller, new OperatorMul());
		buttonMult.setToolTipText("Multiply.");
		buttonsPanel.add(buttonMult);

		// Fourth row

		button1 = new ButtonDigit(controller, Constants.ONE);
		buttonsPanel.add(button1);

		button2 = new ButtonDigit(controller, Constants.TWO);
		buttonsPanel.add(button2);

		button3 = new ButtonDigit(controller, Constants.THREE);
		buttonsPanel.add(button3);

		buttonSub = new ButtonOperator(controller, new OperatorSub());
		buttonSub.setToolTipText("Substract.");
		buttonsPanel.add(buttonSub);

		// Fifth row

		button0 = new ButtonDigit(controller, Constants.ZERO);
		buttonsPanel.add(button0);

		buttonPoint = new ButtonDigit(controller, Constants.POINT);
		buttonsPanel.add(buttonPoint);

		buttonEqual = new ButtonOperator(controller, new OperatorEquals());
		buttonEqual.setColor2(new Color(0, 50, 200));
		buttonEqual.setToolTipText("Equals.");
		buttonsPanel.add(buttonEqual);

		buttonAdd = new ButtonOperator(controller, new OperatorAdd());
		buttonAdd.setToolTipText("Add.");
		buttonsPanel.add(buttonAdd);
	}

	public void update(CalculatorModel data) {
		display.setText(data.getDisplay());
	}
}
