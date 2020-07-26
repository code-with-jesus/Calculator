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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class JRoundButton extends javax.swing.JButton {

	// --------------------------------------------------------------------------
	// Properties
	// --------------------------------------------------------------------------

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/** Button shape. */
	private Shape shape;

	/** Points of degraded. */
	private Point point1, point2;

	/** Colors. */
	private Color color1, color2;

	/** Button size or dimension. */
	private Dimension dimension;

	// --------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------

	public JRoundButton() {
		this("");
	}

	public JRoundButton(String text) {
		super(text);
		setContentAreaFilled(false);
		setForeground(Color.white);
		setFont(new Font("Arial", 3, 29));

		point1 = new Point();
		point2 = new Point();
		color1 = new Color(255, 255, 255);
		color2 = new Color(0, 0, 0);
		dimension = getPreferredSize();
	}

	// --------------------------------------------------------------------------
	// Methods
	// --------------------------------------------------------------------------

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON));

		point2.x = getWidth();
		point2.y = getHeight();

		if (getModel().isArmed()) {
			point2.x *= 0.75;
			point2.y *= 0.75;

		} else if (getModel().isRollover()) {
			point2.x *= 1.5;
			point2.y *= 1.5;
		}

		GradientPaint gp = new GradientPaint(point1, color1, point2, color2);
		g2.setPaint(gp);
		g2.fillOval(0, 0, dimension.width - 1, dimension.height - 1);

		super.paintComponent(g2);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.drawOval(0, 0, dimension.width - 1, dimension.height - 1);
	}

	@Override
	public boolean contains(Point p) {
		return contains(p.x, p.y);
	}

	@Override
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds()))
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());

		return shape.contains(x, y);
	}

	@Override
	public void setPreferredSize(Dimension d) {
		super.setPreferredSize(d);
		dimension.width = d.width;
		dimension.height = d.height;
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		dimension.width = width;
		dimension.height = height;
	}

	@Override
	public void setSize(Dimension d) {
		setSize(d.width, d.height);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		dimension.width = width;
		dimension.height = height;
	}

	@Override
	public void setBounds(Rectangle r) {
		setBounds(r.x, r.y, r.width, r.height);
	}
}
