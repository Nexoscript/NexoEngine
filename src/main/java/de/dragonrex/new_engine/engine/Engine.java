package de.dragonrex.new_engine.engine;

import de.dragonrex.new_engine.camera.Camera2D;
import de.dragonrex.new_engine.camera.Camera3D;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public abstract class Engine {

    protected long window;
    protected int width = 800;
    protected int height = 600;
    protected String title = "Engine";

    protected Camera2D camera2D;
    protected Camera3D camera3D;

    private double lastTime;
    private float deltaTime;

    public Engine(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    /**
     * Startet die Engine
     */
    public void start() {
        initGLFW();
        initOpenGL();
        initCameras();
        initGame(); // Spiel-spezifische Initialisierung

        lastTime = GLFW.glfwGetTime();
        loop();

        cleanup();
    }

    /**
     * GLFW Fenster und Kontext initialisieren
     */
    private void initGLFW() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!GLFW.glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (window == 0)
            throw new RuntimeException("Failed to create GLFW window");

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSwapInterval(1); // VSync
        GLFW.glfwShowWindow(window);
    }

    /**
     * OpenGL Kontext initialisieren
     */
    private void initOpenGL() {
        GL.createCapabilities();
        GL11.glClearColor(0f, 0f, 0f, 1f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    /**
     * Kameras initialisieren
     */
    private void initCameras() {
        camera2D = new Camera2D(width, height);
        camera3D = new Camera3D((float)Math.toRadians(70f), (float)width/height, 0.01f, 100f);
    }

    /**
     * GameLoop
     */
    private void loop() {
        while (!GLFW.glfwWindowShouldClose(window)) {
            double currentTime = GLFW.glfwGetTime();
            deltaTime = (float)(currentTime - lastTime);
            lastTime = currentTime;

            update(deltaTime);
            render();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        }
    }

    /**
     * Cleanup beim Beenden
     */
    private void cleanup() {
        cleanupGame(); // Spiel-spezifische Ressourcen
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    // ==========================
    // Abstrakte Methoden für das Spiel
    // ==========================
    /**
     * Initialisierung des Spiels (Meshes, Shader, GameObjects)
     */
    protected abstract void initGame();

    /**
     * Update Logik
     */
    protected abstract void update(float deltaTime);

    /**
     * Rendern aller Objekte
     */
    protected abstract void render();

    /**
     * Cleanup der Spiel-spezifischen Ressourcen
     */
    protected abstract void cleanupGame();

    // ==========================
    // Getter für Kameras
    // ==========================
    public Camera2D getCamera2D() { return camera2D; }
    public Camera3D getCamera3D() { return camera3D; }
    public long getWindow() { return window; }
}
