package controller;

public class ThreadCalc extends Thread{
	
	private int a, b, op;
	
	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.op = op;
	}
	@Override
	public void run() {
		calcula();
	}
	
	private void calcula() {
		try {
			Thread.sleep(op*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int res = 0;
		String opera = "";
		
		switch (op) {
		case 0:
			res = a + b;
			opera = "+";			
			break;
		case 1:
			res = a - b;
			opera = "-";			
			break;
		case 2:
			res = a * b;
			opera = "*";			
			break;
		case 3:
			res = a / b;
			opera = "/";			
			break;
		}
		System.out.println(a + " " + opera + " " + b + " = " + res);
	}
}
