package com.zelda.fightlandords.servers;

import com.zelda.fightlandords.domain.Poker;

import java.util.List;


public class IsBigger {
	public static boolean isBigger(List<Poker> leftList,List<Poker> rightList,List<Poker> choose){
		//����ϼҲ�Ҫ ���ߵ�һ�ѳ�  list=null
		if(leftList==null||leftList.size()==0){
			if(rightList==null||rightList.size()==0){
				//���Ҷ���Ҫ
				return true;
			}else{
				if(isRealBigger(rightList, choose)){
					return true;
				}
				return false;
			}
		}else{
			if(isRealBigger(leftList, choose)){
				return true;
			}
			return false;
		}
		
	}
	public static boolean isRealBigger(List<Poker> leftList,List<Poker> choose){
		// �����ж������ǲ���һ��
		String paiXing = IsTruePoker.isTruePoker(leftList);
		if (paiXing.equals(IsTruePoker.isTruePoker(choose))) {
			// �����������жϴ�С
			if (IsTruePoker.DANZHANG.equals(paiXing)) {
				// ����
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.WANGZHA.equals(paiXing)) {
				// ��ը
				// ������
			} else if (IsTruePoker.DUIZI.equals(paiXing)) {
				// ����
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.SANGETOU.equals(paiXing)) {
				// ����
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.SANDAIYI.equals(paiXing)) {
				// ����һ
				if (isBiggerSan(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.SANDAIYIDUI.equals(paiXing)) {
				// ����һ��
				if (isBiggerSan(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.ZHADAN.equals(paiXing)) {
				// ը��
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.SHUNZI.equals(paiXing)) {
				// ˳��
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.LIANDUI.equals(paiXing)) {
				// ����
				if (isBiggerLast(leftList, choose)) {
					return true;
				}
				return false;
			} else if (IsTruePoker.SHUANGFEI.equals(paiXing)) {
				// ˫��
				if (isBiggerSan(leftList, choose)) {
					return true;
				}
				return false;
			} 
		}else if(choose.size()==2){
			//�ж��ǲ�����ը
			if(IsTruePoker.isWangZha(choose)){
				return true;
			}
			return false;
		} else if(choose.size()==4){
			//�ж��ǲ���ը��
			if(IsTruePoker.isSame(choose, 4)){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static boolean isBiggerLast(List<Poker> list,List<Poker> choose){
		if(list.get(list.size()-1).getColor()<choose.get(choose.size()-1).getColor()){
			return true;
		}
		return false;
	}
	
	public static boolean isBiggerSan(List<Poker> list,List<Poker> choose){
		int a=san(list);
		int b=san(choose);
		if(a==-1||b==-1){
			return false;
		}
		if(b>a){
			return true;
		}
		return false;
	}
	
	public static int san(List<Poker> list){
		for(int i=0;i<list.size()-2;i++){
			int a=list.get(i).getColor();
			int b=list.get(i+1).getColor();
			int c=list.get(i+2).getColor();
			if(a==b&&a==c){
				return a;
			}
		}
		return -1;
	}
}
