package de.dragonrex.new_engine.example.objects;

import de.dragonrex.new_engine.engine.objects.GameObject3D;
import de.dragonrex.new_engine.shader.Mesh;
import de.dragonrex.new_engine.shader.Shader;

public class Cube3D extends GameObject3D {

    public Cube3D(float x, float y, float z, Mesh mesh, Shader shader) {
        super(x, y, z, mesh, shader);
    }

    @Override
    public void update() {
        angle += 1f; // Rotation pro Frame
    }
}
