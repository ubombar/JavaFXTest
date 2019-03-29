package core;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameApplication extends Application
{
    private Canvas canvas;
    private GraphicsContext context;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(Game.getCurrent().getSettings().getWindowTitle());
        Group root = new Group();
        canvas = new Canvas(
                 Game.getCurrent().getSettings().getWindowWidth(),
                 Game.getCurrent().getSettings().getWindowHeight());
        context = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        // Events
        canvas.setOnMouseClicked(me -> Game.getCurrent().invokeMouseEvent(me));
        canvas.setOnMouseDragged(me -> Game.getCurrent().invokeMouseEvent(me));
        canvas.setOnMousePressed(me -> Game.getCurrent().invokeMouseEvent(me));
        canvas.setOnMouseReleased(me -> Game.getCurrent().invokeMouseEvent(me));

        canvas.setOnKeyPressed(ke -> Game.getCurrent().invokeKeyEvent(ke));
        canvas.setOnKeyReleased(ke -> Game.getCurrent().invokeKeyEvent(ke));
        canvas.setOnKeyTyped(ke -> Game.getCurrent().invokeKeyEvent(ke));

        double delay = 1000.0 / Game.getCurrent().getSettings().getWindowRequestedFPS();

        timeline = new Timeline(new KeyFrame(Duration.millis(delay), event ->
            Game.getCurrent().getSettings().getWindowRenderer().render(context, (int) canvas.getWidth(), (int) canvas.getHeight(), delay)
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        primaryStage.setScene(new Scene(root));
        // primaryStage.setResizable(false);
        Image icon = Game.getCurrent().getSettings().getWindowRenderer().getIcon(
                Game.getCurrent().getSettings().getWindowIconName());

        if (icon != null)
            primaryStage.getIcons().add(icon);

        primaryStage.show();
        Game.getCurrent().getSettings().getWindowRenderer().initialize();
        timeline.play();
    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
        timeline.stop();
        Game.getCurrent().getSettings().getWindowRenderer().destroy();
    }
}
