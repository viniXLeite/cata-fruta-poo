package Mochila;
import Frutas.*;

public class Mochila {
	public Fruta[] mochila;
	public int top;
	public int size;
	
	
	public Mochila(int tamanhoMochila) {
		this.top = -1;
		this.size = tamanhoMochila;
		this.mochila = new Fruta[size];
	}
	
	
	
	
}
