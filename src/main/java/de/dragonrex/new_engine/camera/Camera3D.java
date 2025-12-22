package de.dragonrex.new_engine.camera;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera3D {
    private Vector3f position;
    private float pitch; // Rotation X axis
    private float yaw; // Rotation Y axis
    private float roll; // Rotation Z axis

    private Matrix4f projection;
    private Matrix4f view;

    public Camera3D(float fov, float aspect, float near, float far) {
        position = new Vector3f(0f, 0f, 3f);
        pitch = 0f;
        yaw = 0f;
        roll = 0f;

        projection = new Matrix4f().perspective(fov, aspect, near, far);
        view = new Matrix4f().translate(0f, 0f, -3f); // Kamera zurück
        updateViewMatrix();
    }

    public void move(Vector3f delta) {
        position.add(delta);
        updateViewMatrix();
    }

    public void rotate(float dpitch, float dyaw, float droll) {
        pitch += dpitch;
        yaw += dyaw;
        roll += droll;
        updateViewMatrix();
    }

    public void setPosition(float x, float y, float z) {
        position.set(x, y, z);
        updateViewMatrix();
    }

    public void updateViewMatrix() {
        view.identity()
                .rotate((float)Math.toRadians(pitch), 1f, 0f, 0f)
                .rotate((float)Math.toRadians(yaw), 0f, 1f, 0f)
                .rotate((float)Math.toRadians(roll), 0f, 0f, 1f)
                .translate(-position.x, -position.y, -position.z);
    }

    public Matrix4f getProjection() { return projection; }
    public Matrix4f getView() { return view; }
}