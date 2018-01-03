package com.zelda.fightlandords.servers;

import javax.swing.JLabel;

import com.alibaba.fastjson.JSON;
import com.zelda.fightlandords.domain.Msg;
import com.zelda.fightlandords.frame.MainFrame;
import com.zelda.fightlandords.socket.Connect;


public class CountThread extends Thread{
	
	private volatile boolean stopRequested;
    private Thread runThread;
	
	private JLabel naoZhong;
	private int daoJiShi;
	
	
	public void run() {
		runThread = Thread.currentThread();
        stopRequested = false;
		while(daoJiShi>=0&&!stopRequested){
			if(daoJiShi==0&& MainFrame.out.isEnabled()){
				//����
				Connect.sendMes.setMsg(JSON.toJSONString(new Msg(MainFrame.myId,null)));
			}
			naoZhong.setText(daoJiShi+"");
			daoJiShi--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public void stopRequest() {
        stopRequested = true;
        if ( runThread != null ) {
            runThread.interrupt();
        }
    }
	public JLabel getNaoZhong() {
		return naoZhong;
	}

	public void setNaoZhong(JLabel naoZhong) {
		this.naoZhong = naoZhong;
	}

	public int getDaoJiShi() {
		return daoJiShi;
	}

	public void setDaoJiShi(int daoJiShi) {
		this.daoJiShi = daoJiShi;
	}
	public CountThread(JLabel naoZhong, int daoJiShi) {
		super();
		this.naoZhong = naoZhong;
		this.daoJiShi = daoJiShi;
	}
	public CountThread() {
	}
}
