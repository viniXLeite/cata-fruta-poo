package KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, setasReleased, setasPressed;
	public boolean wPressed, sPressed, aPressed, dPressed, teclasReleased, teclasPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
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
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_S) {
			sPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_A) {
			aPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_D) {
			dPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
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
