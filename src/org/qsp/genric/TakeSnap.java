package org.qsp.genric;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class TakeSnap {
	public static void takePic(WebDriver driver, String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File screenShotSave = new File(path);
		Files.copy(screenshot, screenShotSave);
	}
}
