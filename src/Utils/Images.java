package Utils;

import javax.swing.*;
import java.awt.*;

public final class Images {
    private Images() {}

    public static ImageIcon getImage(String imgName, int width, int height) {
        ImageIcon imgIcon = new ImageIcon("src/Resources/" + imgName + ".png");
        Image scaledImg = imgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
