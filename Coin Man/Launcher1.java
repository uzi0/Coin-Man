import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
public class Launcher1
{
  public static void main (String[] args)
  {
mainGame myProgram = new mainGame();
    LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
    
    cfg.resizable = false;
    cfg.width = 800;
    cfg.height = 600;
    LwjglApplication launcher = new LwjglApplication(myProgram, cfg);
  }
}
