package ghost.mods.essential.settings;

import net.minecraft.src.MathHelper;

public class NumberSetting extends Setting {
	
	public float value;
	public float increment;
	public float decrement;
	public float min;
	public float max;
	
	public NumberSetting(String name, String description, float value, float min, float max,float increment, float decrement) {
		super(name, description);
		this.value = value;
		this.increment = increment;
		this.decrement = decrement;
		this.min = min;
		this.max = max;
	}
	
	public NumberSetting(String name, String description) {
		super(name, description);
	}
	
	public NumberSetting(String name) {
		super(name, "");
	}
	
	public NumberSetting withName(String name) {
		this.name = name;
		return this;
	}
	
	public NumberSetting withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public NumberSetting withValue(float value) {
		this.value = value;
		return this;
	}
	
	public NumberSetting withMin(float min) {
		this.min = min;
		return this;
	}
	
	public NumberSetting withMax(float max) {
		this.max = max;
		return this;
	}
	
	public NumberSetting withIncrement(float increment) {
		this.increment = increment;
		this.decrement = increment;
		return this;
	}

	public void incr() {
		if(value+increment >= max) {
			value = max;
		} else {
			value += increment;
		}
	}
	
	public void decr() {
		if(value-decrement <= min) {
			value = min;
		} else {
			value -= decrement;
		}
	}
	
	public float getValue() {
		return value;
	}
	
	public float getIncrement() {
		return increment;
	}

	public void setIncrement(float increment) {
		this.increment = increment;
	}

	public float getDecrement() {
		return decrement;
	}

	public void setDecrement(float decrement) {
		this.decrement = decrement;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public void setValue(float value) {
		float newValue = 0;
		for(float i = 0; (i-1)*increment < value; i++) {
			newValue = (i)*increment;
		}
		this.value = MathHelper.clamp_float(newValue, min, max);
	}

}
