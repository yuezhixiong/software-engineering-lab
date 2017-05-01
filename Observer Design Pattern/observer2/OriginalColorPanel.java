package observer2;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;


public class OriginalColorPanel extends ColorPanel{

	public OriginalColorPanel(Color color){
		super(color);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (DisplayColors.hueSlider != null && DisplayColors.saturationSlider != null && DisplayColors.brightnessSlider != null) {
			float newHue = (float) DisplayColors.hueSlider.getValue() / 100;
			float newSaturation = (float) DisplayColors.saturationSlider.getValue() / 100;
			float newBrightness = (float) DisplayColors.brightnessSlider.getValue() / 100;
			Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);	
			
			this.setColor(newColor);		
		}
	}

}
