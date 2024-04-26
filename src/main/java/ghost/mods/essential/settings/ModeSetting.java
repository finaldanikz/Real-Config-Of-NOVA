package ghost.mods.essential.settings;

import java.util.ArrayList;
import java.util.List;

import ghost.mods.essential.Category;
import ghost.mods.essential.Mod;

public class ModeSetting extends Setting {

	public List<String> modes = new ArrayList<String>();
	
	public String current;
	
	public int curr = 0;
	
	public ModeSetting(String name, String description, String...modes) {
		super(name, description);
		for(String s : modes) {
			this.modes.add(s);
		}
		if(curr >= this.modes.size()) {
			curr = 0;
		}
		current = this.modes.get(curr);
	}
	
	public void unDrawSelf() {
		this.setDraw(false);
	}
	
	public void unDrawSettings() {
		for(int i = 0; i < mod.settings.size(); i++) {
			mod.settings.get(i).setDraw(false);
		}
	}
	
	public ModeSetting FireChange() {
		onChange();
		return this;
	}
	
	public void onChange() {
		
	}
	
	public void setValue(String val) {
		if(this.modes.contains(val)) {
			this.current = val;
		}
	}
	
	public void next() {
		++curr;
		if(curr >= this.modes.size()) {
			curr = 0;
		}
		current = this.modes.get(curr);
		onChange();
	}
	
	public String getValue() {
		return current;
	}

}
