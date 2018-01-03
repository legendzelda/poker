package com.zelda.fightlandords.servers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.alibaba.fastjson.JSON;
import com.zelda.fightlandords.domain.Msg;
import com.zelda.fightlandords.domain.Poker;
import com.zelda.fightlandords.frame.MainFrame;
import com.zelda.fightlandords.socket.Connect;


public class OutMouseEvent implements MouseListener{

	private JLabel out;
	private List<JLabel> choose;
	public OutMouseEvent(JLabel out,List<JLabel> choose){
		this.choose=choose;
		this.out=out;
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
		out.setIcon(new ImageIcon(MainFrame.class.getClassLoader().getResource("image/out1.png")));
	}
	public void mouseEntered(MouseEvent e) {
		out.setIcon(new ImageIcon(MainFrame.class.getClassLoader().getResource("image/out3.png")));
	}
	public void mouseClicked(MouseEvent e) {
		int size=choose.size();
		System.out.println("����˳��ư�ť        ������"+size);
		//��ҵ���˳��ư�ť  �ж�choose�Ƿ���ֵ���ж��Ƿ���ϳ��Ʊ�׼���ж��Ƿ������һ�ҳ��Ʊ�׼���ж��Ƿ����ϼң�����choose���JLabel;���choose��������Ϣ��������
		if(choose!=null&&choose.size()>0){
			String s=IsTruePoker.isTruePoker(JLabelToPoker.toPokerList(choose));
			System.out.println(s);
			//��s��=ERROR ˵��������Ϸ����
			//��Ҫ���ж��Ƿ���ϼҳ��ƴ� ���� �Ƿ��Լ��ȳ�
			if(!s.equals(IsTruePoker.ERROR)){
				List<Poker> list=JLabelToPoker.toPokerList(choose);
				System.out.println("�ϼҵ���: "+MainFrame.leftmsg.getList());
				if(IsBigger.isBigger(MainFrame.leftmsg.getList(),MainFrame.rightmsg.getList(), list)){
					System.out.println("�������");
					System.out.println(JSON.toJSONString(new Msg(MainFrame.myId,list)));
					Connect.sendMes.setMsg(JSON.toJSONString(new Msg(MainFrame.myId,list)));
					
				}
			}
		}
	}
	

}
