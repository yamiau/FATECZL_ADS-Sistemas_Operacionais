package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlCar;
import control.GenerateIcon;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Streets extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streets frame = new Streets();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Streets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GenerateIcon icon = new GenerateIcon();
		Semaphore semaphore = new Semaphore(1);
		
		
		JLabel carWE = new JLabel("");
		carWE.setBounds(-100, 280, 130, 110);
		carWE.setIcon(new ImageIcon(icon.generateIcon(carWE)));
		contentPane.add(carWE);
		
		JLabel carNS = new JLabel("");
		carNS.setBounds(194, -100, 130, 110);
		carNS.setIcon(new ImageIcon(icon.generateIcon(carNS)));
		contentPane.add(carNS);
		
		JLabel carEW = new JLabel("");
		carEW.setBounds(550, 170, 130, 110);
		carEW.setIcon(new ImageIcon(icon.generateIcon(carEW)));
		contentPane.add(carEW);
		
		JLabel carSN = new JLabel("");
		carSN.setBounds(310, 550, 130, 110);
		carSN.setIcon(new ImageIcon(icon.generateIcon(carSN)));
		contentPane.add(carSN);
		
		
		JLabel intersection = new JLabel("");
		intersection.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\img\\intersection.png"));
		intersection.setBounds(195, 187, 192, 191);
		contentPane.add(intersection);
		
		JLabel run = new JLabel("");
		run.setBounds(460, 10, 115, 35);
		run.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\run1.png"));
		JLabel[] cars = {carWE, carNS, carEW, carSN};
		run.addMouseListener(new ControlCar(cars, intersection, semaphore, run));
		contentPane.add(run);
			
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\streets.png"));
		lblBG.setBounds(0, 0, 584, 561);
		contentPane.add(lblBG);
	}
}
