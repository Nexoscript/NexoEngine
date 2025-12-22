package de.dragonrex.new_engine.example.objects;

public class CubeVertices {
    public static float[] CUBE_VERTICES = {
            // x, y, z,   r, g, b
            // Front
            -0.5f, -0.5f,  0.5f, 1f, 0f, 0f,
            0.5f, -0.5f,  0.5f, 0f, 1f, 0f,
            0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            -0.5f, -0.5f,  0.5f, 1f, 0f, 0f,
            0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            -0.5f,  0.5f,  0.5f, 1f, 1f, 0f,

            // Back
            -0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            0.5f,  0.5f, -0.5f, 0f, 1f, 1f,
            0.5f, -0.5f, -0.5f, 1f, 1f, 1f,
            -0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            -0.5f,  0.5f, -0.5f, 0f, 1f, 0f,
            0.5f,  0.5f, -0.5f, 0f, 1f, 1f,

            // Left
            -0.5f, -0.5f, -0.5f, 1f, 0f, 0f,
            -0.5f, -0.5f,  0.5f, 0f, 1f, 0f,
            -0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            -0.5f, -0.5f, -0.5f, 1f, 0f, 0f,
            -0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            -0.5f,  0.5f, -0.5f, 1f, 1f, 0f,

            // Right
            0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            0.5f,  0.5f,  0.5f, 0f, 1f, 1f,
            0.5f, -0.5f,  0.5f, 1f, 1f, 1f,
            0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            0.5f,  0.5f, -0.5f, 0f, 1f, 0f,
            0.5f,  0.5f,  0.5f, 0f, 1f, 1f,

            // Top
            -0.5f,  0.5f, -0.5f, 1f, 0f, 0f,
            -0.5f,  0.5f,  0.5f, 0f, 1f, 0f,
            0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            -0.5f,  0.5f, -0.5f, 1f, 0f, 0f,
            0.5f,  0.5f,  0.5f, 0f, 0f, 1f,
            0.5f,  0.5f, -0.5f, 1f, 1f, 0f,

            // Bottom
            -0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            0.5f, -0.5f,  0.5f, 0f, 1f, 1f,
            -0.5f, -0.5f,  0.5f, 1f, 1f, 1f,
            -0.5f, -0.5f, -0.5f, 1f, 0f, 1f,
            0.5f, -0.5f, -0.5f, 0f, 1f, 0f,
            0.5f, -0.5f,  0.5f, 0f, 1f, 1f,
    };
}
