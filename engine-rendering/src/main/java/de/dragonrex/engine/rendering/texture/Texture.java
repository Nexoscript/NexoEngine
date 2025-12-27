package de.dragonrex.engine.rendering.texture;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Texture {
    private int id;
    private int width;
    private int height;

    public Texture(String path) {
        int textId;
        int w, h;

        STBImage.stbi_set_flip_vertically_on_load(false);

        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer iw = stack.mallocInt(1);
            IntBuffer ih = stack.mallocInt(1);
            IntBuffer ic = stack.mallocInt(1);

            ByteBuffer data = STBImage.stbi_load(path, iw, ih, ic, 4);
            if(data == null) {
                throw new RuntimeException("Failed to load texture: " + path);
            }

            w = iw.get();
            h = ih.get();

            textId = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, textId);

            GL11.glTexImage2D(
                    GL11.GL_TEXTURE_2D,
                    0,
                    GL11.GL_RGBA8,
                    w, h,
                    0,
                    GL11.GL_RGBA,
                    GL11.GL_UNSIGNED_BYTE,
                    data
            );

            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);

            STBImage.stbi_image_free(data);
        }

        this.id = textId;
        this.width = w;
        this.height = h;
    }

    public void bind(int slot) {
        GL13.glActiveTexture(GL13.GL_TEXTURE0 + slot);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void cleanUp() {
        GL11.glDeleteTextures(id);
    }
}
