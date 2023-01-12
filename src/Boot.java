import javax.swing.*;

public class Boot extends SuperObject{
    public Boot(){
        name = "Boot";
        image = new ImageIcon("assets/Object/boots.png").getImage();
        collision = true;
    }
}
