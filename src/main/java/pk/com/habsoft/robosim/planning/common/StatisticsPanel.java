/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pk.com.habsoft.robosim.planning.common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pk.com.habsoft.robosim.internal.RPanel;
import pk.com.habsoft.robosim.planning.algos.Algorithm;
import pk.com.habsoft.robosim.planning.internal.AlgorithmListener;
import pk.com.habsoft.robosim.utils.Util;

public class StatisticsPanel extends RPanel implements AlgorithmListener {

	private static final long serialVersionUID = 1L;

	String strExplored = " Explored", strBlocked = "Blocked", strUnExplored = " Un-Explored", strTotal = " Total",
			strPathSize = " Path Length", strResult = " Result", strInstances = " Total Instances";
	JLabel lblExplored, lblBlocked, lblUnExplored, lblTotal, lblPathSize, lblResult, lblInstances;

	public StatisticsPanel(int width, int height, String label) {
		super(width, height, label);

		setLayoutMgr(new BorderLayout());

		JPanel pnl = new JPanel();
		createOutputPanelContents(pnl);

		add(pnl, BorderLayout.NORTH);
	}

	private void createOutputPanelContents(JPanel pnlOutput) {

		pnlOutput.setLayout(new GridLayout(4, 2, 5, 3));

		pnlOutput.add(new JLabel(strExplored));
		lblExplored = new JLabel();
		pnlOutput.add(lblExplored);
		pnlOutput.add(new JLabel(strBlocked));
		lblBlocked = new JLabel();
		pnlOutput.add(lblBlocked);
		pnlOutput.add(new JLabel(strUnExplored));
		lblUnExplored = new JLabel();
		pnlOutput.add(lblUnExplored);
		pnlOutput.add(new JLabel(strTotal));
		lblTotal = new JLabel();
		pnlOutput.add(lblTotal);
		pnlOutput.add(new JLabel(strPathSize));
		lblPathSize = new JLabel();
		pnlOutput.add(lblPathSize);
		pnlOutput.add(new JLabel(strInstances));
		lblInstances = new JLabel();
		pnlOutput.add(lblInstances);
		pnlOutput.add(new JLabel(strResult));
		lblResult = new JLabel();
		pnlOutput.add(lblResult);
		lblResult.setForeground(Color.RED);

	}

	@Override
	public void algorithmUpdate(Algorithm algorithm) {
		if (algorithm != null) {
			lblExplored.setText(Util.padRight(Integer.toString(algorithm.getExploredSize()), 20));
			lblUnExplored.setText(Util.padRight(Integer.toString(algorithm.getUnExploredSize()), 20));
			lblBlocked.setText(Util.padRight(Integer.toString(algorithm.getBlockedSize()), 20));
			lblTotal.setText(Util.padRight(Integer.toString(algorithm.getTotalSize()), 20));
			lblPathSize.setText(Util.padRight(Integer.toString(algorithm.getPathSize()), 20));
			lblResult.setText(Util.padRight(algorithm.getResult(), 20));
			lblInstances.setText(Util.padRight(Integer.toString(algorithm.getTotalInstances()), 20));
		} else {
			lblExplored.setText("0");
			lblUnExplored.setText("0");
			lblBlocked.setText("0");
			lblTotal.setText("0");
			lblPathSize.setText("0");
			lblResult.setText("NA");
			lblTotal.setText("0");
		}

	}

}
