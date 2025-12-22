package de.dragonrex.new_engine.example;

import de.dragonrex.new_engine.camera.Camera3D;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class CameraController3D {

    private Camera3D camera;
    private long window;

    public CameraController3D(Camera3D camera, long window) {
        this.camera = camera;
        this.window = window;
    }

    public void update(float deltaTime) {
        float speed = 2f * deltaTime;

        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) {
            camera.move(new Vector3f(0f, 0f, -speed));
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
            camera.move(new Vector3f(0f, 0f, speed));
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            camera.move(new Vector3f(-speed, 0f, 0f));
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            camera.move(new Vector3f(speed, 0f, 0f));
        }
    }
}

