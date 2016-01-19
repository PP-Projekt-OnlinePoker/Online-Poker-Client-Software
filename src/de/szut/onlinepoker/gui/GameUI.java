package de.szut.onlinepoker.gui;

import de.szut.onlinepoker.game.Player;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.IOException;
import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.system.MemoryUtil.*;

public class GameUI extends Thread implements GUI {

    // We need to strongly reference callback instances.
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback keyCallback;

    private Texture[] cardTextures;


    // The window handle
    private long window;

    @Override
    public void run() {
        try {
            //Spiel initialisieren
            init();

            //Gameloop
            loop();

            //Fenster wieder zerstören
            glfwDestroyWindow(window);
            keyCallback.release();
        } catch (IOException ex) {
            System.out.println("Failed while loading game textures");
        } finally {
            // Terminate GLFW and release the GLFWerrorfun
            glfwTerminate();
            errorCallback.release();
        }
    }

    private Texture[] loadCardTextures() {
        //Zwei verschachtelte For-loops für alle Karten
        //Laden mit: TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/meineTextur.png"));

        return null;
    }

    private void init() throws IOException {
        //Texturen für die Karten laden
        this.loadCardTextures();

        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (glfwInit() != GL11.GL_TRUE)
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int WIDTH = (int) screenSize.getWidth();
        int HEIGHT = (int) screenSize.getHeight() - 70;

        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Texas Hold'em. Loose your money online!", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                    glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
            }
        });

        // Get the resolution of the primary monitor
        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        // Center our window
        glfwSetWindowPos(
                window,
                (GLFWvidmode.width(vidmode) - WIDTH) / 2,
                (GLFWvidmode.height(vidmode) - HEIGHT) / 2
        );

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);

        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    private synchronized void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the ContextCapabilities instance and makes the OpenGL
        // bindings available for use.
        GLContext.createFromCurrent();

        // Set the clear color
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (glfwWindowShouldClose(window) == GL_FALSE) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glfwSwapBuffers(window); // swap the color buffers

            //Rendern
            render();

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    private void render(){
        renderTable();
        renderPlayers();
    }

    private void renderTable(){
        renderHoleCards();
    }

    private void renderHoleCards(){

    }

    private void renderPlayers(){
        renderPlayerCards();
    }

    private void renderPlayerCards(){

    }

    public synchronized void raise(Player p) {
        //TODO: Animate Raise
    }

    public synchronized void fold(Player p) {
        //TODO: Animate Fold
    }

    public synchronized void call(Player p) {
        //TODO: Animate Call
    }

    public synchronized void bet(Player p) {
        //TODO: Animate Bet
    }

    public synchronized void check(Player p) {
        //TODO: Animate Check
    }

    public synchronized void allIn(Player p) {
        //TODO: Animate All In
    }

    public synchronized void tableBegin() {
        //TODO: Animate beginning
    }

    public synchronized void flopRound() {
        //TODO: Animate Flop
    }

    public synchronized void turnRound() {
        //TODO: Animate Turn
    }

    public synchronized void riverRound() {
        //TODO: Animate River
    }
}