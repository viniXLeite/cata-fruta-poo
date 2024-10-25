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
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
			setasPressed = true;
			setasReleased = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			setasPressed = true;
			setasReleased = false;
		}

		if(code == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
		
		if(code == KeyEvent.VK_UP) {
			wPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_DOWN) {
			sPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_LEFT) {
			aPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			dPressed = true;
			teclasPressed = false;
			teclasReleased = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
				int code = e.getKeyCode();

				
				if(code == KeyEvent.VK_W) {
					upPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_S) {
					downPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_A) {
					leftPressed = false;
					setasPressed = false;
					setasReleased = true;
				}
				if(code == KeyEvent.VK_D) {
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
				
				if(code == KeyEvent.VK_UP) {
					wPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_DOWN) {
					sPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_LEFT) {
					aPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}
				if(code == KeyEvent.VK_RIGHT) {
					dPressed = false;
					teclasPressed = false;
					teclasReleased = true;
				}

	}
	

}
