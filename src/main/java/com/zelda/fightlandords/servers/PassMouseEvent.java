package com.zelda.fightlandords.servers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.alibaba.fastjson.JSON;
import com.zelda.fightlandords.domain.Msg;
import com.zelda.fightlandords.frame.MainFrame;
import com.zelda.fightlandords.socket.Connect;

public class PassMouseEvent implements MouseListener{
	
	private JLabel pass;
	private List<JLabel> choose;
	public PassMouseEvent(JLabel pass,List<JLabel> choose){
		this.choose=choose;
		this.pass=pass;
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
		pass.setIcon(new ImageIcon(MainFrame.class.getClassLoader().getResource("image/pass.png")));
	}
	public void mouseEntered(MouseEvent e) {
		pass.setIcon(new ImageIcon(MainFrame.class.getClassLoader().getResource("image/pass1.png")));
	}
	public void mouseClicked(MouseEvent e) {
		//���ѡ�񲻳�  ��choose��ѡ����˿�ȡ��ѡ�� ���choose ���Ͳ�����Ϣ��������
		MainFrame.allPokerDown(choose);
		choose.removeAll(choose);
		Connect.sendMes.setMsg(JSON.toJSONString(new Msg(MainFrame.myId,null)));
	}
}
