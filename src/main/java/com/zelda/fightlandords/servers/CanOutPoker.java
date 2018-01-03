package com.zelda.fightlandords.servers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;



public class CanOutPoker {
	
	public static List<CountThread> list=new ArrayList<CountThread>();
	public static void setCanOut(JLabel out,List<JLabel> choose,JLabel pass){
		out.addMouseListener(new OutMouseEvent(out, choose));
		out.setEnabled(true);
		
		pass.addMouseListener(new PassMouseEvent(pass, choose));
		pass.setEnabled(true);
	}
	
	public static void setCannotOut(JLabel out,JLabel pass){
		out.addMouseListener(null);
		out.setEnabled(false);
		
		pass.addMouseListener(null);
		pass.setEnabled(false);
	}
	
	/**
	 * ���õ���ʱ
	 * @param who ��˭�ĵ���ʱ  0 �Լ� 1�ұ� 2���
	 * @param jLabel 
	 */
	public static void setCountShow(int who,JLabel jLabel){
		for(int i=0;i<list.size();i++){
			list.get(i).stopRequest();
		}
		list.retainAll(list);
		if(who==0){
			jLabel.setBounds(380, 355, 50, 50);
		}else if (who==1) {
			jLabel.setBounds(680, 200, 50, 50);
		}else if (who==2) {
			jLabel.setBounds(70, 200, 50, 50);
		}
		//jLabel.setVisible(true);
		// ����ʱ
		CountThread countThread=new CountThread(jLabel,30);
		list.add(countThread);
		countThread.start();
	}
}
