package com.zelda.fightlandords.frame;

import com.zelda.fightlandords.domain.MyFrame;
import com.zelda.fightlandords.socket.Connect;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Fuckland extends MyFrame {

	private static final long serialVersionUID = 881792201169758236L;
	
	private static JButton jButton;
	public static JTextField jTextField;
	public static JLabel peoples;
	public static Fuckland fuckland;
	public static void main(String[] args) {
		fuckland = new Fuckland();
		fuckland.setLayout(null);
		fuckland.setSize(250, 200);
		fuckland.setLocationRelativeTo(null);// ���þ��У�Ҫ�������ô��ڴ�С֮��
		
		Font font=new Font("΢���ź�", 1, 13) ;
		
		JLabel jLabel=new JLabel("����������:");
		jLabel.setFont(font);
		jLabel.setBounds(10, 20, 70, 20);
		
		jTextField=new JTextField();
		jTextField.setFont(font);
		jTextField.setBounds(82, 20, 150, 20);
		
		JLabel jLabel2=new JLabel("��ǰ����:");
		jLabel2.setFont(font);
		jLabel2.setBounds(10, 60, 60, 20);
		
		peoples=new JLabel("0");
		peoples.setFont(font);
		peoples.setBounds(72, 60, 10, 20);
		
		JLabel jLabel3=new JLabel("(����������3ʱ,��Ϸ��ʼ)");
		jLabel3.setFont(font);
		jLabel3.setBounds(10, 80, 180, 20);
		
		jButton=new JButton("׼     ��");
		jButton.setBounds(10, 130, 225, 30);
		jButton.setFont(font);
		
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=jTextField.getText();
				if(name!=null&&name.length()>0){
					jButton.setEnabled(false);
					boolean b= Connect.connect();
					if(b){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, new JLabel("<html><h2><font color='red'>����������</font></h2></html>"), "��ʾ", JOptionPane.INFORMATION_MESSAGE); 
				}
			}
		});
		
		fuckland.add(jButton);
		fuckland.add(jLabel3);
		fuckland.add(peoples);
		fuckland.add(jLabel2);
		fuckland.add(jTextField);
		fuckland.add(jLabel);
		fuckland.repaint();
	}
	

}
