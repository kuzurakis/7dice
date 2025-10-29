package com.sevendice.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;
import com.sevendice.core.Game;
import com.sevendice.core.GameFactory;

public class MainController {
    @FXML public MenuItem menuNew;
    @FXML public MenuItem menuSave;
    @FXML public MenuItem menuLoad;
    @FXML public MenuItem menuExit;
    @FXML public StackPane boardContainer;
    @FXML public VBox playerPanel;

    private Game game;

    @FXML
    public void initialize() {
        // Подключить обработчики, загрузить стартовую сцену меню или форму новой игры
        menuNew.setOnAction(e -> onNewGame());
        menuExit.setOnAction(e -> System.exit(0));
    }

    private void onNewGame() {
        // Временно: создаём игру 2 игроков — фабрика вернёт объект Game
        this.game = GameFactory.createNewGame(2);
        // TODO: отрисовать board в boardContainer и панель игрока
    }
}