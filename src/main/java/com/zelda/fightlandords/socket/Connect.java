package com.zelda.fightlandords.socket;

import com.zelda.fightlandords.frame.Fuckland;

import java.net.Socket;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Connect {
	public static final String IP_ADDR = "172.16.5.102";// 服务器地址
	public static final int PORT = 8866;// 服务器端口号

	private static  Logger loger = Logger.getLogger("com.zelda.fightlandords.socket.Connect");

	private static Socket socket;

	public static SendMes sendMes;
	public static boolean connect(){
		try {
			socket = new Socket(IP_ADDR, PORT);
			ReadMes readThread = new ReadMes(socket);
			readThread.setName("readThread");
			//开启读进程
			readThread.start();
			
			//开启写进程,内容显示到窗口
			sendMes=new SendMes(socket);
			sendMes.setName("sendThread");
			sendMes.setMsg(Fuckland.jTextField.getText().trim());
			sendMes.start();
			loger.info("连接成功");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, new JLabel("<html><h1><font color='red'>"+e.getMessage()+"</font></h1></html>"), "错误", JOptionPane.ERROR_MESSAGE);
		}
			return  false;
	}
}
