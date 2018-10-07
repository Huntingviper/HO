package module.specialEvents;

import core.model.HOVerwaltung;
import core.module.DefaultModule;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class SpecialEventsModule extends DefaultModule {

	@Override
	public KeyStroke getKeyStroke() {
		return KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_MASK);
	}

	@Override
	public int getModuleId() {
		return SPECIALEVENTS;
	}

	@Override
	public String getDescription() {
		return  HOVerwaltung.instance().getLanguageString("Tab_SpecialEvents");
	}

	@Override
	public JPanel createTabPanel() {
		return new SpecialEventsPanel();
	}

}
