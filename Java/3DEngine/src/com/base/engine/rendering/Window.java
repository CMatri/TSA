package com.base.engine.rendering;

import com.base.engine.core.Vector2f;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class Window {
	public static void createWindow(int width, int height, String title) {
		Display.setTitle(title);
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static void render() {
		Display.update();
	}

	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}

	public static int getWidth() {
		return Display.getDisplayMode().getWidth();
	}

	public static int getHeight() {
		return Display.getDisplayMode().getHeight();
	}

    public static void bindAsRenderTarget() {
        glBindFramebuffer(GL_DRAW_FRAMEBUFFER, 0);
        glViewport(0, 0, getWidth(), getHeight());
    }

	public static String getTitle() {
		return Display.getTitle();
	}

	public static void dispose() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}

	public Vector2f getCenter() {
		return new Vector2f(getWidth() / 2, getHeight() / 2);
	}
}
