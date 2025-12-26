package de.dragonrex.engine.rendering.light;

public class LightManager {

    private static DirectionalLight sun;

    public static void setSun(DirectionalLight light) {
        sun = light;
    }

    public static DirectionalLight getSun() {
        return sun;
    }
}
