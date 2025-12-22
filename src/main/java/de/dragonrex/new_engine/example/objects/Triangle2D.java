package de.dragonrex.new_engine.example.objects;

import de.dragonrex.new_engine.engine.objects.GameObject2D;
import de.dragonrex.new_engine.shader.Mesh;
import de.dragonrex.new_engine.shader.Shader;

public class Triangle2D extends GameObject2D {

    public Triangle2D(float x, float y, Mesh mesh, Shader shader) {
        this.x = x;
        this.y = y;
        this.mesh = mesh;
        this.shader = shader;
    }

    @Override
    public void update() {
        // Beispiel: kleine Bewegung
        x += 0.1f;
        if(x > 800) x = -50;
    }
}
