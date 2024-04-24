# Four in a row GUI

This project provides a GUI built with Java Swing for playing Four in a Row.

The actual implementation for the game is not in this library, you have to implement it yourself, in order to do that you must provide an implementation for the `IBoard` interface.

```java
package pt.brunojesus.fourinrow.gui;

import java.awt.Color;

/**
 * IBoard interface
 * <p>
 * Defines the required interface in order to interact with the {@link GameWindow}
 *
 * @author Bruno Jesus
 * @since 1.0
 */
public interface IBoard {

    /**
     * Gets the item on the desired position
     *
     * @param col the Column to access (0 based)
     * @param row the Row to access (0 based)
     * @return the player color, <b>null</b> if position is empty
     */
    Color getItemInPosition(int col, int row);

    /**
     * Gets the winner
     *
     * @return the color of the winner, <b>null</b> if none
     */
    Color getWinner();

    /**
     * Plays in the desired column
     *
     * @param col   the Column to play into
     * @param color the player's color to play
     */
    void play(int col, Color color);

    /**
     * Plays in the desired column.
     * The {@link Color} is determined automatically
     *
     * @param col the Column to play into
     */
    void play(int col);
}
```

With a board implementation done, getting the GUI can be accomplished just by
instantiating it:
```java
public class Application {
    public static void main(String[] args) {
        IBoard board = new Board();
        new GameWindow(board);
    }
}
```

## Installing

Add `mvn.brunojesus.pt` repository to your project's `pom.xml` `<distributionManagement>` section:

```xml
<distributionManagement>
    <repository>
        <id>mvn-brunojesus</id>
        <name>Bruno Jesus MVN Repo</name>
        <url>https://mvn.brunojesus.pt/releases</url>
    </repository>
</distributionManagement>
```

Add the dependency to your project under `<dependencies>`:

```xml
<dependencies>
    <dependency>
        <groupId>pt.brunojesus.fourinrow</groupId>
        <artifactId>fourinrow-gui</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```