package core;

@SuppressWarnings("unused")
public class GameSettings
{
    public static final GameSettings DEFAULT = new GameSettings(c -> {});

    @SuppressWarnings("unused")
    public static class GameSettingsContainer
    {
        public int windowWidth = 1280;
        public int windowHeight = 720;
        public String windowTitle = "";
        public int windowRequestedFPS = 30;
        public Renderer windowRenderer = new Renderer();
        public String windowIconName = "app_icon.png";
    }

    public interface GameSettingsListener
    {
        void onConstruct(GameSettingsContainer c);
    }

    private GameSettingsContainer settings;

    public GameSettings(GameSettingsListener l)
    {
        this.settings = new GameSettingsContainer();
        l.onConstruct(settings);
    }

    public int getWindowWidth()
    {
        return settings.windowWidth;
    }

    public int getWindowHeight()
    {
        return settings.windowHeight;
    }

    public String getWindowTitle()
    {
        return settings.windowTitle;
    }

    public int getWindowRequestedFPS()
    {
        return settings.windowRequestedFPS;
    }

    public Renderer getWindowRenderer()
    {
        return settings.windowRenderer;
    }

    public String getWindowIconName()
    {
        return settings.windowIconName;
    }
}
