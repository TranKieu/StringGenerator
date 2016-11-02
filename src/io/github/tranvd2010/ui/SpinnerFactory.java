package io.github.tranvd2010.ui;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public final class SpinnerFactory {
	/**
	 * @wbp.factory
	 */
	public static JSpinner createJSpinner(int value, int minimum, int maximum, int stepSize) {
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(value, minimum, maximum, stepSize));
		return spinner;
	}
}