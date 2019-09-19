package threadcomsemaforo.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadDungeon extends Thread {

	private String name;
	private int speed;
	private int traveledPath;
	private static boolean torch = true;
	private static boolean stone = true;
	private static boolean[] doors = new boolean[4];
	private static String[] exit = new String[4];

	private long startItem;
	private long endItem;
	private String pegouTocha;
	private String pegouPedra;

	Random r = new Random();
	Semaphore torchSemaphore = new Semaphore(1);
	Semaphore stoneSemaphore = new Semaphore(1);
	Semaphore doorSemaphhore = new Semaphore(1);

	public ThreadDungeon(String name) {
		this.name = name;
	}

// Walk to torch
	private void walk1() {
		name = currentThread().getName();
		while (traveledPath < 500) {
			speed = (r.nextInt(3) + 1);
			traveledPath += speed;
			System.out.println("O Cavaleiro " + name + " percorreu " + traveledPath + "m");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

// Walk to stone
	private void walk2() {
		startItem = System.currentTimeMillis();
		endItem = startItem + 500;
		while (traveledPath < 1500) {
			speed = (r.nextInt(3) + 1); // check if boost time end
			if (System.currentTimeMillis() < endItem) {
				if (name.contains("torch")) { // check if knight have item
					speed += 2;
				}
			} else {
				name = currentThread().getName();
			}
			traveledPath += speed;
			System.out.println("O Cavaleiro " + name + " percorreu " + traveledPath + "m");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

// walk to doors	
	private void walk3() {
		startItem = System.currentTimeMillis();
		endItem = startItem + 500;
		while (traveledPath < 2000) {
			speed = (r.nextInt(3) + 1); // check if boost time end
			if (System.currentTimeMillis() < endItem) {
				if (name.contains("stone")) { // check if knight have item
					speed += 2;
				}
			} else {
				name = currentThread().getName();
			}
			traveledPath += speed;
			System.out.println("O Cavaleiro " + name + " percorreu " + traveledPath + "m");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" == Cavaleiro " + name + " chegou! ==");
	}

	private void pickItem(String item) {
		if (item.equalsIgnoreCase("torch")) {
			System.out.println("!! Cavaleiro " + name + " Pegou a tocha !!");
			name += " com a tocha ";
			pegouTocha = currentThread().getName();
		}
		if (item.equalsIgnoreCase("stone")) {
			System.out.println("!! Cavaleiro " + name + "  Pegou a preda !!");
			name += " com a preda ";
			pegouPedra = currentThread().getName();
		}
	}

	public void choosingDoor() {
		int pickedDoor = 0;
		do{
			pickedDoor = r.nextInt(4);
			doors[pickedDoor] = true;
		} while (doors[pickedDoor] == false);
		
		System.out.println("Cavaleiro " + name + " escolheu a porta " + pickedDoor);
		System.out.println("Atrás da porta " + pickedDoor + " o cavaleiro " + name + "encontrou " + exit[pickedDoor]);
	}

	public void sortGoodDoor() {
		int goodDoor = r.nextInt(4);
		exit[goodDoor] = "a saída, O cavaleiro " + name + " está salvo";
		for (int i = 0; i < 4; i++) {
			if (exit[i] == null) {
				exit[i] = "a morte... foi morto por " + sortMonster() + " e agora descansa no céu";
			}
		}
	}

	public String sortMonster() {
		int monster = r.nextInt(4) + 1;
		switch (monster) {
		case 1:
			return "um Macacão";
		case 2:
			return "um Lagartão";
		case 3:
			return "um humano com fantasia de baixo orçamento o que dificulta identificar qual é o monstro";
		case 4:
			return "um boletão";
		default:
			return "Sérgio Malandro";
		}
	}

	@Override
	public void run() {
		walk1();
		try {
			torchSemaphore.acquire();
			if (torch) {
				torch = false;
				if (!torch) {
					pickItem("torch");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			torchSemaphore.release();
		}
		walk2();
		try {
			if (stone) {
				stoneSemaphore.acquire();
				stone = false;
				pickItem("stone");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			stoneSemaphore.release();
		}
		walk3();

		sortGoodDoor();
		try {
			doorSemaphhore.acquire();
			choosingDoor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			doorSemaphhore.release();
		}

	}

}
