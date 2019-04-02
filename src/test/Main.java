package test;

import core.Game;
import core.GameSettings;
import game.ballgame.LevelDungeon;
import game.platormer.LevelPlatformer;
import game.quadzillion.QuadZillionLevel;

public class Main
{
    public static void main(String[] args)
    {
        new Game(GameSettings.DEFAULT, new QuadZillionLevel());
    }
}
