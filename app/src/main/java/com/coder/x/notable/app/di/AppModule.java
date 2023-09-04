package com.coder.x.notable.app.di;

import android.content.Context;

import com.coder.x.notable.app.db.DBHelper;


import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    public static DBHelper provideDBHelper(@ApplicationContext Context context) {
        return new DBHelper(context);
    }
}
