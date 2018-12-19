package launch;

import ui.component.Switcher;
import ui.listener.mouse.MouseClickListener;
import ui.listener.mouse.MouseEvent;

public class TestMouseClickListener extends MouseClickListener {
    private Switcher switcher;

    public TestMouseClickListener(Switcher switcher) {
        this.switcher = switcher;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        switcher.switchContent();
    }
}
