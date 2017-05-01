package observer3;

import java.awt.Color;
import java.beans.PropertyChangeListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class OriginalColorPanel extends ColorPanel implements ChangeListener{

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
			this.addPropertyChangeListener(DisplayColors.complementaryColorPanel);	//To inform ComplementaryColorPanel
			this.setColor(newColor);		
		}
	}

}
