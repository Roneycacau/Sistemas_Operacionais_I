package controller;


public class ThreadSeq extends Thread{
	
	private int n;
	private int i;
	private double res;
	
	
	public ThreadSeq(int  n, int i) {
		this.n = n;
		this.i = i;
	}

	@Override
	public void run() {
		sequencia();
	}
	
	private void sequencia() {
		res = 4*fracao();
		System.out.print(i + " ==> ");
		System.out.println(res);
	}

	private double fracao() {
		boolean troca = false;
		for (double i = 1; i<n; i +=2) {
			if(troca) {
				troca = false;
				res += 1/i;
			}else {
				troca = true;
				res -= 1/i;
			}
		}
		return res;
	}
}
