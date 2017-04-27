package observer3;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener{
	
	public ComplementaryColorPanel(Color color){
		super(color);
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (DisplayColors.hueSlider != null && DisplayColors.saturationSlider != null && DisplayColors.brightnessSlider != null) {
			float newHue = (float) DisplayColors.hueSlider.getValue() / 100;
			float newSaturation = (float) DisplayColors.saturationSlider.getValue() / 100;
			float newBrightness = (float) DisplayColors.brightnessSlider.getValue() / 100;	
			float complementaryHue = newHue - (float) 0.5;
			if (complementaryHue < 0) {
				complementaryHue = complementaryHue + 1;
			}
			Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
			this.setColor(complementaryColor);		
		}
	}
}
