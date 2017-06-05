package com.tdx.demo.copyassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tdx.demo.library.PathUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PathUtil.showAndroidDir();
    }
}
SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
				Locale locale = null;
				if (!prefs.contains("SharedPreferences_language")){
					if (Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage())){
						locale = Locale.JAPANESE;
					} else if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage())){
						locale = Locale.CHINESE;
					} else if (Locale.ENGLISH.getLanguage().equals(Locale.getDefault().getLanguage())){
						locale = Locale.ENGLISH;
					} else {
						locale = Locale.ENGLISH;
					}
				} else {
					String option = prefs.getString("SharedPreferences_language", "jp");
					LanguageCommon languageCommon = new LanguageCommon();
					locale = languageCommon.intToLocale(Integer.valueOf(option));
				}

				
				PanatermApplication.appLanguageFlag = locale.getLanguage();
				
				Resources res = getResources();
				Configuration config = res.getConfiguration();
				
				if (!config.locale.getLanguage().equals(PanatermApplication.appLanguageFlag)){
				
					PanatermApplication.osLanguageFlag = locale.getLanguage();
					config.locale = locale;
					DisplayMetrics dm = res.getDisplayMetrics();
					res.updateConfiguration(config, dm);
				}
