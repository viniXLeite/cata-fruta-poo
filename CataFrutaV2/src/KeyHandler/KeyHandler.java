package KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A classe {@code KeyHandler} implementa a interface {@link KeyListener} para capturar e gerenciar
 * eventos de teclado, permitindo a interação do usuário com o jogo ou a aplicação.
 * 
 * <p>Esta classe monitora o estado de teclas específicas (como teclas de movimento) e armazena
 * esses estados em variáveis booleanas, que outras classes podem acessar para verificar se uma
 * tecla específica foi pressionada ou liberada.</p>
 * 
 */

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, setasReleased, setasPressed;
	public boolean wPressed, sPressed, aPressed, dPressed, teclasReleased, teclasPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
     * Chamado quando uma tecla é pressionada. Define as variáveis booleanas
     * correspondentes para {@code true} se a tecla estiver em uso.
     *
     * @param e o evento de tecla pressionada
     */

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
			setasPressed = true;
			setasReleased = false;
		}

		if(code == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
		
		if(code == KeyEvent.VK_W) {
			wPressed = true;
			teclasPressed = true;
			teclasReleased = false;
		}
		if(code == KeyEvent.VK_S) {
			sPressed = true;
			teclasPressed = true;
			teclasReleased = false;
		}
		if(code == KeyEvent.VK_A) {
			aPressed = true;
			teclasPressed = true;
			teclasReleased = false;
		}
		if(code == KeyEvent.VK_D) {
			dPressed = true;
			teclasPressed = true;
			teclasReleased = false;
		}
		
		
	}

	/**
     * Chamado quando uma tecla é liberada. Define as variáveis booleanas
     * correspondentes para {@code false} se a tecla foi liberada.
     *
     * @param e o evento de tecla liberada
     */

	@Override
	public void keyReleased(KeyEvent e) {
		
				int code = e.getKeyCode();

				
				if(code == KeyEvent.VK_UP) {
					upPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_DOWN) {
					downPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_LEFT) {
					leftPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_RIGHT) {
					rightPressed = false;
					setasPressed = false;
					setasReleased = true;
				}

				if(code == KeyEvent.VK_SPACE) {
					spacePressed = false;
					setasPressed = false;
					setasReleased = true;
				}
		//////////////////////////////////////
				
				if(code == KeyEvent.VK_W) {
					wPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_S) {
					sPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_A) {
					aPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_D) {
					dPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}

	}
	

}
