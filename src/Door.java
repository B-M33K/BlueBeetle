import javax.swing.*;

public class Door extends SuperObject{
    public Door(){
        name = "Door";
        image = new ImageIcon("assets/Object/door.png").getImage();
        collision = true;
    }
}
