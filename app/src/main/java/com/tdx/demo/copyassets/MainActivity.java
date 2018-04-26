package com.tdx.demo.copyassets;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.tdx.demo.library.PathUtil;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PathUtil.showAndroidDir();

        //切换到英语
        TextView changeLanguage2En = (TextView) findViewById(R.id.changeLanguage2En);
        changeLanguage2En.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
				Configuration config = res.getConfiguration();
                Locale locale;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //android 7.0
                    locale = getResources().getConfiguration().getLocales().get(0);
                } else {
                    locale = getResources().getConfiguration().locale;
                }
                //判断当前是否已经是英文
                if (!Locale.ENGLISH.getLanguage() .equals(locale.getLanguage())){
                    //不是英文,切换到英文
                    config.locale = Locale.ENGLISH;
                    DisplayMetrics dm = res.getDisplayMetrics();
					res.updateConfiguration(config, dm);
                }
            }
        });

        TextView changeLanguage2Cn = (TextView) findViewById(R.id.changeLanguage2Cn);
        changeLanguage2Cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                Configuration config = res.getConfiguration();
                Locale locale;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //android 7.0
                    locale = getResources().getConfiguration().getLocales().get(0);
                } else {
                    locale = getResources().getConfiguration().locale;
                }
                if (!Locale.CHINESE.getLanguage() .equals(locale.getLanguage())){
                    config.locale = Locale.CHINESE;
                    DisplayMetrics dm = res.getDisplayMetrics();
                    res.updateConfiguration(config, dm);
                }
            }
        });
    }
}
//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//				Locale locale = null;
//				if (!prefs.contains("SharedPreferences_language")){
//					if (Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage())){
//						locale = Locale.JAPANESE;
//					} else if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage())){
//						locale = Locale.CHINESE;
//					} else if (Locale.ENGLISH.getLanguage().equals(Locale.getDefault().getLanguage())){
//						locale = Locale.ENGLISH;
//					} else {
//						locale = Locale.ENGLISH;
//					}
//				} else {
//					String option = prefs.getString("SharedPreferences_language", "jp");
//					LanguageCommon languageCommon = new LanguageCommon();
//					locale = languageCommon.intToLocale(Integer.valueOf(option));
//				}
//
//
//				PanatermApplication.appLanguageFlag = locale.getLanguage();
//
//				Resources res = getResources();
//				Configuration config = res.getConfiguration();
//
//				if (!config.locale.getLanguage().equals(PanatermApplication.appLanguageFlag)){
//
//					PanatermApplication.osLanguageFlag = locale.getLanguage();
//					config.locale = locale;
//					DisplayMetrics dm = res.getDisplayMetrics();
//					res.updateConfiguration(config, dm);
//				}
