/*========================================================================
 * Clock.java
 * May 16, 2011 11:05:47 PM | ttiemens
 * Copyright (c) 2011 Tim Tiememsn
 *========================================================================
 * This file is part of ClockInJava.
 *
 *    ClockInJava is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    ClockInJava is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with ClockInJava.  If not, see <http://www.gnu.org/licenses/>.
 */

package tiemens.clock.simple;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.JFrame;

/**
 * A simple Clock
 */
public class MainSimpleClock 
	extends javax.swing.JComponent 
{
	// ==================================================
	// class static data
	// ==================================================

	/**
	 * generated serialUID
	 */
	private static final long serialVersionUID = -902418120271381675L;


	// ==================================================
	// class static methods
	// ==================================================

	public static void main(String[] args) 
	{
		JFrame window = new JFrame("Clock In Java");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainSimpleClock clock = new MainSimpleClock();
		clock.setFont(new Font("sansserif", Font.PLAIN, 48));

		window.setContentPane(clock);

		window.pack();
		window.setVisible(true);
	}

	// ==================================================
	// instance data
	// ==================================================

	protected DecimalFormat tf;
	protected DecimalFormat tflz;

	protected volatile boolean done = false;

	// ==================================================
	// factories
	// ==================================================

	// ==================================================
	// constructors
	// ==================================================

	public MainSimpleClock() 
	{
		new Thread(new Runnable() 
		{
			public void run() 
			{
				while (!done) 
				{
					MainSimpleClock.this.repaint();
					try 
					{
						Thread.sleep(700);
					}
					catch (InterruptedException e) 
					{
						done = true;
					}
				}
			}
		}).start();

		tf = new DecimalFormat("#0");
		tflz = new DecimalFormat("00");
	}


	// ==================================================
	// public methods
	// ==================================================

	public void stop() 
	{
		done = true;
	}

	/**
	 *  Get current time and draw centered time string. 
	 */
	@Override
	public void paint(Graphics g) 
	{
		Calendar myCal = Calendar.getInstance();
		int hour = myCal.get(Calendar.HOUR);
		if (hour == 0) 
		{
			hour = 12;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(tf.format(hour));
		sb.append(':');
		sb.append(tflz.format(myCal.get(Calendar.MINUTE)));
		sb.append(':');
		sb.append(tflz.format(myCal.get(Calendar.SECOND)));
		String s = sb.toString();
		FontMetrics fm = getFontMetrics(getFont());
		int x = (getSize().width - fm.stringWidth(s)) / 2;
		// System.out.println("Size is " + getSize());
		final int ascent = fm.getAscent();
		final int descent = fm.getDescent();
		final int top = 0;
		final int bottom = getSize().height;

		int y = (top + ((bottom + 1 - top)) / 2) - 
				((ascent + descent) / 2) +
				ascent;
		// int y = getSize().height -
		// 0; // puts on bottom
		// (getSize().height -
		// (fm.getAscent() + fm.getDescent())) / 2;
		g.drawString(s, x, y); // y was 10
	}

	@Override
	public Dimension getPreferredSize() 
	{
		return new Dimension(300, 100);
	}

	@Override
	public Dimension getMinimumSize() 
	{
		return new Dimension(50, 10);
	}

	// ==================================================
	// non public methods
	// ==================================================

}
