package com.zelda.fightlandords.servers;

import com.zelda.fightlandords.domain.Poker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;


public class JLabelToPoker {
	
	public static List<Poker> toPokerList(List<JLabel> list){
		List<Poker> pokers=new ArrayList<Poker>();
		for(int i=0;i<list.size();i++){
			JLabel jLabel=list.get(i);
			int id=Integer.parseInt(jLabel.getName());
			int color=Integer.parseInt(jLabel.getText());
			Poker p=new Poker(color, id, "", false);
			pokers.add(p);
		}
		return pokers;
	}
}
