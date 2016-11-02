package io.github.tranvd2010.ui;

import io.github.tranvd2010.utils.IGenerator;
import io.github.tranvd2010.utils.StringGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * StringGeneratorUI.java
 *
 * @author Viet Dung Tran (tranvd2010@gmail.com)
 *
 */

public class StringGeneratorUI extends JFrame {

	private static final long serialVersionUID = 2010L;
	private final JPanel contentPane;

	private final DefaultListModel<String> listModell = new DefaultListModel<String>();

	private final JList<String> listString = new JList<String>(listModell);

	private JCheckBox checkKlein;
	private JCheckBox checkSonder;
	private JCheckBox checkGross;
	private JCheckBox checkZahl;
	private JCheckBox checkErlaubte;

	private JTextField txtSonderChar;

	private JSpinner spinAnzahl;
	private JSpinner spinLaeng;

	private JButton buGenerieren;

	/**
	 * Create the frame.
	 */
	public StringGeneratorUI() {
		setTitle("StringGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblHttp = new JLabel("http://tranvd2010.github.io   ");
		lblHttp.setForeground(Color.BLUE);
		lblHttp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(
							new URI("http://tranvd2010.github.io"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		lblHttp.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblHttp, BorderLayout.SOUTH);

		bauGui();
		listenerRegister();
	}

	/**
	 * 
	 */
	private void bauGui() {
		JPanel panMain = new JPanel();
		panMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panMain, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Character",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblAnzahl = new JLabel("Anzahl : ");
		lblAnzahl.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblLaeng = new JLabel("Stringlänge : ");
		lblLaeng.setHorizontalAlignment(SwingConstants.TRAILING);

		spinLaeng = SpinnerFactory.createJSpinner(6, 5, 512, 1);

		spinAnzahl = SpinnerFactory.createJSpinner(1, 1, 100, 1);

		buGenerieren = new JButton("Generieren");

		GroupLayout gl_panMain = new GroupLayout(panMain);
		gl_panMain
				.setHorizontalGroup(gl_panMain
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panMain
										.createSequentialGroup()
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												190, GroupLayout.PREFERRED_SIZE)
										.addGap(28)
										.addGroup(
												gl_panMain
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panMain
																		.createSequentialGroup()
																		.addGroup(
																				gl_panMain
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblAnzahl)
																						.addComponent(
																								lblLaeng))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panMain
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								spinLaeng,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								spinAnzahl,
																								GroupLayout.PREFERRED_SIZE,
																								42,
																								Short.MAX_VALUE)))
														.addComponent(
																buGenerieren))
										.addContainerGap(22, Short.MAX_VALUE))
						.addComponent(scrollPane, Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE));
		gl_panMain
				.setVerticalGroup(gl_panMain
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panMain
										.createSequentialGroup()
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												214, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_panMain
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panMain
																		.createSequentialGroup()
																		.addGap(37)
																		.addGroup(
																				gl_panMain
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblAnzahl)
																						.addComponent(
																								spinAnzahl,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(27)
																		.addGroup(
																				gl_panMain
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblLaeng)
																						.addComponent(
																								spinLaeng,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(39)
																		.addComponent(
																				buGenerieren)
																		.addContainerGap())
														.addGroup(
																gl_panMain
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				panel,
																				GroupLayout.PREFERRED_SIZE,
																				167,
																				Short.MAX_VALUE)))));

		checkKlein = new JCheckBox();
		checkKlein.setText("Kleinbuchstaben");
		checkKlein.setSelected(true);

		checkGross = new JCheckBox();
		checkGross.setText("Großbuchstaben");
		checkGross.setSelected(true);

		checkZahl = new JCheckBox();
		checkZahl.setText("Zahlen");

		checkSonder = new JCheckBox();
		checkSonder.setText("Sonderzeichen");

		checkErlaubte = new JCheckBox();
		checkErlaubte.setText("Erlaubte Sonderzeichen");

		txtSonderChar = new JTextField();
		txtSonderChar.setText("!?@$%&#");
		txtSonderChar.setEnabled(false);
		txtSonderChar.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						checkKlein,
																						GroupLayout.DEFAULT_SIZE,
																						162,
																						Short.MAX_VALUE)
																				.addComponent(
																						checkGross,
																						GroupLayout.DEFAULT_SIZE,
																						162,
																						Short.MAX_VALUE)
																				.addComponent(
																						checkZahl,
																						GroupLayout.DEFAULT_SIZE,
																						162,
																						Short.MAX_VALUE)
																				.addComponent(
																						checkSonder,
																						GroupLayout.DEFAULT_SIZE,
																						162,
																						Short.MAX_VALUE)
																				.addComponent(
																						checkErlaubte,
																						GroupLayout.DEFAULT_SIZE,
																						162,
																						Short.MAX_VALUE))
																.addContainerGap())
												.addComponent(
														txtSonderChar,
														Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE,
														168, Short.MAX_VALUE))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(checkKlein)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkGross)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkZahl)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkSonder)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkErlaubte)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSonderChar,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		listString.setCellRenderer(new CellRenderer());

		scrollPane.setViewportView(listString);
		panMain.setLayout(gl_panMain);

	}

	/**
	 * 
	 */
	private void listenerRegister() {

		checkSonder.addItemListener(item -> {
			if (item.getStateChange() == ItemEvent.SELECTED) {
				txtSonderChar.setEnabled(false);
				checkErlaubte.setSelected(false);
				validate();
			}
		});

		checkErlaubte.addItemListener(item -> {
			if (item.getStateChange() == ItemEvent.SELECTED) {
				checkSonder.setSelected(false);
				txtSonderChar.setEnabled(true);

			} else {
				txtSonderChar.setEnabled(false);
			}
			validate();
		});

		buGenerieren
				.addActionListener(action -> {
					listModell.removeAllElements();

					IGenerator igenerator = new IGenerator() {

						@Override
						public void addRows(String zeichenkette) {
							listModell.addElement(zeichenkette);  //Call-Back
						}
					};

					Character[] sonderChars = (checkErlaubte.isSelected()) ? txtSonderChar
							.getText().chars().mapToObj(c -> (char) c)
							.toArray(Character[]::new)
							: new Character[] {};
					;

					StringGenerator generator = new StringGenerator(igenerator,
							(Integer) spinLaeng.getValue(), checkKlein
									.isSelected(), checkGross.isSelected(),
							checkZahl.isSelected(), checkSonder.isSelected(),
							sonderChars);
					
					
					for (int i = 0; i < (Integer) spinAnzahl.getValue(); i++) {
						generator.run();
					}
					
					
				});
	}
}
