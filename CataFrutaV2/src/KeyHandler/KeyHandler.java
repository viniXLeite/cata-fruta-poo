package KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, released, pressed;

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
			pressed = true;
			released = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
			pressed = true;
			released = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
			pressed = true;
			released = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			pressed = true;
			released = false;
		}

		if(code == KeyEvent.VK_SPACE) {
			spacePressed = true;
			pressed = true;
			released = false;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
				int code = e.getKeyCode();

				
				if(code == KeyEvent.VK_W) {
					upPressed = false;
					pressed = false;
					released = true;
				}
				if(code == KeyEvent.VK_S) {
					downPressed = false;
					pressed = false;
					released = true;
				}
				if(code == KeyEvent.VK_A) {
					leftPressed = false;
					pressed = false;
					released = true;
				}
				if(code == KeyEvent.VK_D) {
					rightPressed = false;
					pressed = false;
					released = true;
				}

				if(code == KeyEvent.VK_SPACE) {
					spacePressed = false;
					pressed = false;
					released = true;
				}
		
	}
	

}
